package com.kino.study.single;

/**
 * 懒汉式
 * @author kino
 * @date 2024/6/25 23:03
 */
public class Single1 {
    private static Single1 instance;

    private Single1() {

    }

    public static Single1 getInstance() {
        // 线程不安全
        // if (instance == null) {
        //     instance = new Single1();
        // }

        // 线程安全
        if (instance == null) {
            synchronized (Single1.class) {
                if (instance == null) {
                    instance = new Single1();
                }
            }
        }
        return instance;
    }
}
