package com.kino.study.demo1.handler;

import com.kino.study.demo1.entity.MetricsEntity;

/**
 * 责任链模式, 将指标统计拆分成不同的功能
 * @author kino
 * @date 2024/6/25 00:46
 */
public interface MetricsHandler {
    void handle(MetricsEntity metrics, double currentValue);
}
