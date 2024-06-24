package com.kino.study.demo1.statistical;

import org.springframework.stereotype.Component;

/**
 * 计算平均值
 * @author kino
 * @date 2024/6/24 23:14
 */
@Component
public class AvgStatistical extends IStatistical{

    private double cumulativeSum = 0;
    private int count = 0;

    public Double calculation(double currentValue) {
        // 更新累积总和和计数
        cumulativeSum += currentValue;
        count++;

        // 返回累积平均值
        return cumulativeSum / count;
    }
}
