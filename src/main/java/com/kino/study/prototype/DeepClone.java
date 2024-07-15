package com.kino.study.prototype;

import org.junit.Test;

/**
 * @author kino
 * @date 2024/7/15 23:36
 */
public class DeepClone {
    @Test
    public void test() {
        Class aClass1 = new Class(1, new User(1, "kino"));
        Class aClass2 = (Class) aClass1.clone();
        aClass2.user = (User) aClass1.getUser().clone();

        User user = aClass1.getUser();
        user.setName("kino1");

        System.out.println(aClass1 == aClass2);  // false
        System.out.println(aClass1.getUser() == aClass2.getUser()); // false
    }

    @Test
    public void test1() {
        User user1 = new User(1, "kino1");
        User user2 = (User) user1.clone();
        user1.setName("kino2");
        System.out.println(user1 == user2);
    }
}
