package com.kino.study.demo1.storage;

import com.kino.study.demo1.entity.MetricsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kino
 * @date 2024/6/25 01:09
 */
@Component
public class StorageContext {
    @Autowired
    private List<StorageStrategy> strategies;

    public void save(MetricsEntity metrics) {
        for (StorageStrategy strategy : strategies) {
            strategy.save(metrics);
        }
    }
}
