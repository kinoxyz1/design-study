package com.kino.study.demo1.handle;

import com.kino.study.demo1.entity.MetricsEntity;
import com.kino.study.demo1.statistical.PercentileStatistical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kino
 * @date 2024/6/25 00:59
 */
@Component
public class PercentileHandler implements MetricsHandler {

    @Autowired
    private PercentileStatistical percentile;

    @Override
    public void handle(MetricsEntity metrics, double currentValue) {
        metrics.setPercentile(percentile.calculation(currentValue));
    }
}
