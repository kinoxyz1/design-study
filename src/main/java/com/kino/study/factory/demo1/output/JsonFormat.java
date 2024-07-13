package com.kino.study.factory.demo1.output;

import com.google.gson.Gson;
import com.kino.study.factory.demo1.entity.MetricsEntity;
import org.springframework.stereotype.Component;

/**
 * @author kino
 * @date 2024/6/25 21:59
 */
@Component
public class JsonFormat implements OutputFormat {
    @Override
    public String format(MetricsEntity metrics) {
        // JSON格式实现
        return new Gson().toJson(metrics);
    }
}
