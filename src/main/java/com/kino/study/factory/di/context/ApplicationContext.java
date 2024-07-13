package com.kino.study.factory.di.context;

/**
 * @author kino
 * @date 2024/7/13 18:35
 */
public interface ApplicationContext {
    Object getBean(String beanId);
}
