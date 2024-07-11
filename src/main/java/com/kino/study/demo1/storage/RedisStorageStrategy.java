package com.kino.study.demo1.storage;

import com.kino.study.demo1.entity.MetricsEntity;
import org.springframework.stereotype.Service;

/**
 * @author kino
 * @date 2024/6/24 23:11
 */
@Service
public class RedisStorageStrategy implements StorageStrategy {
    @Override
    public void save(MetricsEntity metrics) {
        // TODO: 调用redis jdbc接口
        System.out.println("调用redis jdbc接口");
    }
}
