package com.kino.study.factory.di.context.xml;

import com.kino.study.factory.di.context.ApplicationContext;
import com.kino.study.factory.di.definition.BeanDefinition;
import com.kino.study.factory.di.factory.BeansFactory;
import com.kino.study.factory.di.parser.BeanConfigParser;
import com.kino.study.factory.di.parser.XmlBeanConfigParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author kino
 * @date 2024/7/13 18:36
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {

    private BeanConfigParser parser;
    private BeansFactory factory;

    /**
     * 1. 解析 xml
     * 2. 创建 bean
     * @param configLocation
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        parser = new XmlBeanConfigParser();
        factory = new BeansFactory();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream(configLocation);
            if (in == null) {
                throw new RuntimeException("Can not find config file: " + configLocation);
            }
            List<BeanDefinition> beanDefinitions = parser.parse(in);
            factory.addBeanDefinitions(beanDefinitions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }
}
