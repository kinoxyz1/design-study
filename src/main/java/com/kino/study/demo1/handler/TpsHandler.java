package com.kino.study.demo1.handler;

import com.kino.study.demo1.entity.MetricsEntity;
import com.kino.study.demo1.statistical.TpsStatistical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kino
 * @date 2024/6/25 01:01
 */
@Component
public class TpsHandler implements MetricsHandler {

    @Autowired
    private TpsStatistical tps;

    @Override
    public void handle(MetricsEntity metrics, double currentValue) {
        metrics.setTps(tps.calculation(currentValue));
    }
}
