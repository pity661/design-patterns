package com.wenky.基础.java基础.Lambda表达式;

import java.util.function.Predicate;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-09 12:54
 **/
public class MyTest {
    public static void main(String[] args) {
        //
        MyInterface inf = () -> {
            System.out.println("Hello World");
        };
        inf.hello();

        Predicate<Integer> pre = x -> x > 1;
        // 取反
        Predicate<Integer> preN = pre.negate();
        System.out.println(pre.test(1));
        System.out.println(preN.test(1));
    }
}
