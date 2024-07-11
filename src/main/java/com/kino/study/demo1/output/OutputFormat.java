package com.kino.study.demo1.output;

import com.kino.study.demo1.entity.MetricsEntity;

/**
 * @author kino
 * @date 2024/6/25 21:59
 */
public interface OutputFormat {
    String format(MetricsEntity metrics);
}
