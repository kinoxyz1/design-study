package com.kino.study.factory.demo1.statistical;

import org.springframework.stereotype.Component;

/**
 * 计算和
 * @author kino
 * @date 2024/6/24 23:14
 */
@Component
public class SumStatistical extends IStatistical{
    private double sum;

    public double calculation(double currentValue) {
        return sum + currentValue;
    }
}
