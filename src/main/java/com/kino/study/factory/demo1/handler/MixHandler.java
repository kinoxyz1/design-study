package com.kino.study.factory.demo1.handler;

import com.kino.study.factory.demo1.entity.MetricsEntity;
import com.kino.study.factory.demo1.statistical.MixStatistical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kino
 * @date 2024/6/25 00:58
 */
@Component
public class MixHandler implements MetricsHandler {

    @Autowired
    private MixStatistical mix;

    @Override
    public void handle(MetricsEntity metrics, double currentValue) {
        metrics.setMix(mix.calculation(currentValue));
    }
}
