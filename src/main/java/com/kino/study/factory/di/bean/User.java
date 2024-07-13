package com.kino.study.factory.di.bean;

/**
 * @author kino
 * @date 2024/7/13 18:41
 */
public class User {
    private String uuid;
    private String name;
    private int age;

    public User(String uuid, String name, int age) {
        this.uuid = uuid;
        this.name = name;
        this.age = age;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
