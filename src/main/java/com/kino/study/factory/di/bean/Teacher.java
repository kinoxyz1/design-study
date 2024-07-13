package com.kino.study.factory.di.bean;

/**
 * @author kino
 * @date 2024/7/13 18:41
 */
public class Teacher {
    private String uuid;
    private String name;
    private int age;

    public Teacher(String uuid, String name, int age) {
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
        return "Teacher{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
