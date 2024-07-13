package com.kino.study.factory.demo1.statistical;

import org.springframework.stereotype.Component;

/**
 * 计算最小值
 * @author kino
 * @date 2024/6/24 23:16
 */
@Component
public class MixStatistical extends IStatistical{
    private double mix = -1;

    public double calculation(double currentValue) {
        if (mix == -1 || currentValue < mix) {
            mix = currentValue;
        }
        return mix;
    }
}
