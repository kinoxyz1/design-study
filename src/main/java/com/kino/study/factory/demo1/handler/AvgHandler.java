package com.kino.study.factory.demo1.handler;

import com.kino.study.factory.demo1.entity.MetricsEntity;
import com.kino.study.factory.demo1.statistical.AvgStatistical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kino
 * @date 2024/6/25 00:47
 */
@Component
public class AvgHandler implements MetricsHandler {

    @Autowired
    private AvgStatistical avg;

    @Override
    public void handle(MetricsEntity metrics, double currentValue) {
        metrics.setAvg(avg.calculation(currentValue));
    }
}
