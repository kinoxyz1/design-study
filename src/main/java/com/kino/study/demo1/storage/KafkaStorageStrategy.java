package com.kino.study.demo1.storage;

import com.kino.study.demo1.entity.MetricsEntity;

/**
 * @author kino
 * @date 2024/6/25 01:23
 */
public class KafkaStorageStrategy implements StorageStrategy {
    @Override
    public void save(MetricsEntity metrics) {
        // TODO: 调用kafka 接口
        System.out.println("调用kafka接口");
    }
}
