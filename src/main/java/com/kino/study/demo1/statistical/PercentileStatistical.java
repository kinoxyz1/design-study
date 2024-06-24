package com.kino.study.demo1.statistical;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 计算百分值(保留两位小数)
 * @author kino
 * @date 2024/6/24 23:16
 */
@Component
public class PercentileStatistical extends IStatistical {

    private List<Double> values = new ArrayList<>();

    public Double calculation(double currentValue) {
        values.add(currentValue);
        Collections.sort(values);
        int index = (int) Math.ceil(0.90 * values.size()) - 1; // 90百分位
        return values.get(index);
    }
}
