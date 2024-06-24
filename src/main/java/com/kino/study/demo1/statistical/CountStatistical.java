package com.kino.study.demo1.statistical;

import org.springframework.stereotype.Component;

/**
 * 计算次数
 * @author kino
 * @date 2024/6/24 23:14
 */
@Component
public class CountStatistical extends IStatistical{
    private int count = 0;

    public int calculation(){
        count = count + 1;
        return count;
    }
}
