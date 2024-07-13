package com.kino.study.factory.di.parser;

import com.kino.study.factory.di.definition.BeanDefinition;

import java.io.InputStream;
import java.util.List;

/**
 * @author kino
 * @date 2024/7/13 18:43
 */
public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);
    List<BeanDefinition> parse(String configContent);
}
