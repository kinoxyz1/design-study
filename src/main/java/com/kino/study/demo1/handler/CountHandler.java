package com.kino.study.demo1.handler;

import com.kino.study.demo1.entity.MetricsEntity;
import com.kino.study.demo1.statistical.CountStatistical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kino
 * @date 2024/6/25 00:55
 */
@Component
public class CountHandler implements MetricsHandler {

    @Autowired
    private CountStatistical count;

    @Override
    public void handle(MetricsEntity metrics, double currentValue) {
        metrics.setCount(count.calculation());
    }
}
