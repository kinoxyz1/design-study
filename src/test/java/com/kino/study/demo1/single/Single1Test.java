package com.kino.study.demo1.single;

import com.kino.study.single.Single1;
import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2024/6/25 23:06
 */
public class Single1Test {

    @Test
    public void test1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Single1.getInstance());
            }
        };

        int i = 1;
        int j = 1;
        while (i < 1000) {
            new Thread(runnable).start();
            i++;
        }

        while (j < 1000) {
            new Thread(runnable).start();
            j++;
        }
    }
}
