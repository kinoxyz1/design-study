package com.kino.study.factory.di;

import com.kino.study.factory.di.bean.Teacher;
import com.kino.study.factory.di.bean.User;
import com.kino.study.factory.di.context.ApplicationContext;
import com.kino.study.factory.di.context.xml.ClassPathXmlApplicationContext;

/**
 * @author kino
 * @date 2024/7/13 18:38
 */
public class DiTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/bean.xml");
        User user = (User) context.getBean("user");
        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println(user);
        System.out.println(teacher);
    }
}
