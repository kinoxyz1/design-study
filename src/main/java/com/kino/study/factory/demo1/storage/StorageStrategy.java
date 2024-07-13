package com.kino.study.factory.demo1.storage;

import com.kino.study.factory.demo1.entity.MetricsEntity;

/**
 * 存储接口: 策略模式
 * @author kino
 * @date 2024/6/24 23:08
 */
public interface StorageStrategy {
    // 保存指标信息到外部系统
    void save(MetricsEntity metrics);
}
