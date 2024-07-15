package com.kino.study.prototype;

import org.junit.Test;

/**
 * 浅拷贝
 * @author kino
 * @date 2024/7/15 23:36
 */
public class ShallowClone {
    @Test
    public void test() {
        Class aClass1 = new Class(1, new User(1, "kino"));
        Class aClass2 = (Class) aClass1.clone();

        User user = aClass1.getUser();
        user.setName("kino1");

        System.out.println(aClass1 == aClass2);  // false
        System.out.println(aClass1.getUser() == aClass2.getUser()); // true
    }

    @Test
    public void test1() {
        User user1 = new User(1, "kino1");
        User user2 = (User) user1.clone();
        user1.setName("kino2");
        System.out.println(user1 == user2);
    }
}

class User implements Cloneable {
    protected int id;
    protected String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Class implements Cloneable {
    protected int id;
    protected User user;

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Class(int id, User user) {
        this.id = id;
        this.user = user;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
