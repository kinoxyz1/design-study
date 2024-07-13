package com.kino.study.factory.demo1.statistical;

import org.springframework.stereotype.Component;

/**
 * 计算最大值
 * @author kino
 * @date 2024/6/24 23:15
 */
@Component
public class MaxStatistical extends IStatistical{
    private double max;

    public double calculation(double currentValue) {
        if (max < currentValue) {
            max = currentValue;
        }
        return max;
    }
}
