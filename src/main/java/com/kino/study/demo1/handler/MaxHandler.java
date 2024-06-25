package com.kino.study.demo1.handler;

import com.kino.study.demo1.entity.MetricsEntity;
import com.kino.study.demo1.statistical.MaxStatistical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kino
 * @date 2024/6/25 00:56
 */
@Component
public class MaxHandler implements MetricsHandler {

    @Autowired
    private MaxStatistical max;

    @Override
    public void handle(MetricsEntity metrics, double currentValue) {
        metrics.setMax(max.calculation(currentValue));
    }
}
