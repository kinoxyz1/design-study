package com.kino.study.demo1.handler;

import com.kino.study.demo1.entity.MetricsEntity;
import com.kino.study.demo1.statistical.SumStatistical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kino
 * @date 2024/6/25 01:00
 */
@Component
public class SumHandler implements MetricsHandler {

    @Autowired
    private SumStatistical sum;

    @Override
    public void handle(MetricsEntity metrics, double currentValue) {
        metrics.setSum(sum.calculation(currentValue));
    }
}
