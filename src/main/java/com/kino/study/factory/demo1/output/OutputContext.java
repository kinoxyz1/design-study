package com.kino.study.factory.demo1.output;

import com.kino.study.factory.demo1.entity.MetricsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kino
 * @date 2024/6/25 22:01
 */
@Component
public class OutputContext {
    @Autowired
    private List<OutputTerminal> terminals;
    @Autowired
    private OutputFormat format;

    public void output(MetricsEntity metrics) {
        String formattedMetrics = format.format(metrics);
        for (OutputTerminal terminal : terminals) {
            terminal.output(formattedMetrics);
        }
    }
}
