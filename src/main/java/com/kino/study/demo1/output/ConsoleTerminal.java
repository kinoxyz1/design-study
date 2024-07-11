package com.kino.study.demo1.output;

import org.springframework.stereotype.Component;

/**
 * @author kino
 * @date 2024/6/25 22:01
 */
@Component
public class ConsoleTerminal implements OutputTerminal {
    @Override
    public void output(String formattedMetrics) {
        System.out.println(formattedMetrics);
    }
}
