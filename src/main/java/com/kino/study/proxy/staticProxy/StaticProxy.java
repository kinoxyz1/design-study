package com.kino.study.proxy.staticProxy;

import com.kino.study.factory.di.bean.User;
import org.junit.Test;

/**
 * @author kino
 * @date 2024/7/16 18:54
 */
public class StaticProxy {
    @Test
    public void test() {
        UserService userService = new UserServiceImplProxy();
        userService.add(new User("a123", "kino", 18));
        userService.register(new User("a123", "kino", 18));
    }
}

interface UserService {
    void add(User user);
    void register(User user);
}

class UserServiceImpl implements UserService {
    @Override
    public void add(User user) {
        // TODO: 省略操作数据库步骤
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("add user: "+ user);
    }

    @Override
    public void register(User user) {
        // TODO: 省略操作数据库步骤
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("register user: "+ user);
    }
}

/**
 * 如果被代理类没有继承接口而是一个普通的第三方类, 连编辑都没办法编辑, 那可以采用集成的方式, 如:
 *   class UserServiceImplProxy extends UserServiceImpl {
 */
class UserServiceImplProxy implements UserService {
    private UserServiceImpl userService;

    public UserServiceImplProxy() {
        userService = new UserServiceImpl();
    }

    @Override
    public void add(User user) {
        System.out.println("add user before");
        userService.add(user);
        System.out.println("add user after");
    }

    @Override
    public void register(User user) {
        System.out.println("register user before");
        userService.register(user);
        System.out.println("register user after");
    }
}