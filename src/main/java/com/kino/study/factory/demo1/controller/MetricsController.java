package com.kino.study.factory.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

/**
 * @author kino
 * @date 2024/6/24 23:52
 */
@Controller
@RequestMapping
public class MetricsController {
    @RequestMapping("/test")
    public String test1(){
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "11111";
    }
}
