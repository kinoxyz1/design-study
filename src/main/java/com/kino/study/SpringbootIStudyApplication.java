package com.kino.study;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author kino
 * @date 2024/6/19 19:00
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableScheduling
@EnableConfigurationProperties
public class SpringbootIStudyApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringbootIStudyApplication.class, args);
    }
}
