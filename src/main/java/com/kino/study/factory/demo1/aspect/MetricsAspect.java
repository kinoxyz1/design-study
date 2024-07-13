package com.kino.study.factory.demo1.aspect;

import com.kino.study.factory.demo1.entity.MetricsEntity;
import com.kino.study.factory.demo1.handler.MetricsHandler;
import com.kino.study.factory.demo1.output.OutputContext;
import com.kino.study.factory.demo1.storage.StorageContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 切面
 * @author kino
 * @date 2024/6/24 23:06
 */
@Aspect
@Component
public class MetricsAspect {

    private static final Logger logger = LoggerFactory.getLogger(MetricsAspect.class);

    // 直接注入所有实现了 MetricsHandle 的类
    @Autowired
    private List<MetricsHandler> handler;
    @Autowired
    private StorageContext storageContext;
    @Autowired
    private OutputContext outputContext;

    private long startTime;
    @Before("execution(* com.kino.study.factory.demo1.controller.MetricsController.*(..))")
    public void before(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();
    }

    @After("execution(* com.kino.study.factory.demo1.controller.MetricsController.*(..))")
    public void after(JoinPoint joinPoint) {
        long endTime = System.currentTimeMillis();
        String currentValue = (endTime - startTime) + "";

        MetricsEntity metricsEntity = new MetricsEntity();

        for (MetricsHandler metricsHandle : handler) {
            metricsHandle.handle(metricsEntity, Double.parseDouble(currentValue));
        }

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 1; i < stackTrace.length; i++) {
            StackTraceElement ste = stackTrace[i];

            if (ste.getClassName().contains("com.kino") && ste.getClassName().contains("CGLIB$$")
                    && !ste.getClassName().contains("java.lang.Thread")
                    // && !ste.getClassName().contains("org.springframework.cglib.proxy.MethodProxy")
                    && !ste.getClassName().equals(this.getClass().getName())) {
                logger.info("class name: {}, count: {}",ste.getClassName() , metricsEntity.toString());
            }
        }
        storageContext.save(metricsEntity);
        outputContext.output(metricsEntity);
    }



    /**
     * 说明: 需要在切面里面注入很多统计方法, 很麻烦, 所以改成责任链模式
     */


    // 同下面的解释
    // @Autowired
    // private AvgStatistical avg;
    // @Autowired
    // private CountStatistical count;
    // @Autowired
    // private MaxStatistical max;
    // @Autowired
    // private MixStatistical mix;
    // @Autowired
    // private PercentileStatistical percentile;
    // @Autowired
    // private SumStatistical sum;
    // @Autowired
    // private TpsStatistical tps;

    // @After("execution(* com.jzdata.study.demo1.controller.TestController1.*(..))")
    // public void after(JoinPoint joinPoint) {
    //     long endTime = System.currentTimeMillis();
    //     String currentValue = (endTime - startTime) + "";
    //
    //     MetricsEntity metricsEntity = new MetricsEntity();
    //     metricsEntity.setAvg(avg.calculation(Double.parseDouble(currentValue)));
    //     metricsEntity.setCount(count.calculation());
    //     metricsEntity.setMax(max.calculation(Double.parseDouble(currentValue)));
    //     metricsEntity.setMin(mix.calculation(Double.parseDouble(currentValue)));
    //     metricsEntity.setPercentile(percentile.calculation(Double.parseDouble(currentValue)));
    //     metricsEntity.setSum(sum.calculation(Double.parseDouble(currentValue)));
    //     metricsEntity.setTps(tps.calculation(Double.parseDouble(currentValue)));
    //
    //     StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    //     for (int i = 1; i < stackTrace.length; i++) {
    //         StackTraceElement ste = stackTrace[i];
    //
    //         if (ste.getClassName().contains("com.jzdata") && ste.getClassName().contains("CGLIB$$")
    //                 && !ste.getClassName().contains("java.lang.Thread")
    //                 // && !ste.getClassName().contains("org.springframework.cglib.proxy.MethodProxy")
    //                 && !ste.getClassName().equals(this.getClass().getName())) {
    //             logger.info("class name: {}, count: {}",ste.getClassName() , metricsEntity.toString());
    //         }
    //     }
    // }
}
