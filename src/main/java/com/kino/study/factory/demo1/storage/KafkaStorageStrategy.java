package com.kino.study.factory.demo1.storage;

import com.kino.study.factory.demo1.entity.MetricsEntity;
import org.springframework.stereotype.Service;

/**
 * @author kino
 * @date 2024/6/25 01:23
 */
@Service
public class KafkaStorageStrategy implements StorageStrategy {
    @Override
    public void save(MetricsEntity metrics) {
        // TODO: 调用kafka 接口
        System.out.println("调用kafka接口");
    }
}
