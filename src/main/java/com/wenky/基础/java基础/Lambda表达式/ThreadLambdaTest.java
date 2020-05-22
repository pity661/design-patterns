package com.wenky.基础.java基础.Lambda表达式;

import java.util.concurrent.TimeUnit;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-09 13:14
 **/
public class ThreadLambdaTest {
    public static void main(String[] args) {
        // 普通写法
        new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("general thread");
            }
        }.start();
        System.out.println("general method");

        // lambda写法
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lambda thread");
        }).start();
        System.out.println("lambda method");
    }
}
