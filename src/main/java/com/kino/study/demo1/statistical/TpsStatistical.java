package com.kino.study.demo1.statistical;

import org.springframework.stereotype.Component;

/**
 * 计算tps
 * @author kino
 * @date 2024/6/24 23:16
 */
@Component
public class TpsStatistical extends IStatistical{

    private long startTime = System.currentTimeMillis();
    private int count = 0;

    public Double calculation(double currentValue) {
        count++;
        long currentTime = System.currentTimeMillis();
        double elapsedTime = (currentTime - startTime) / 1000.0;
        return count / elapsedTime;
    }
}
