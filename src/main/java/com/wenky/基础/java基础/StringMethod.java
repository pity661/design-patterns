package com.wenky.基础.java基础;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-01-14 09:44
 **/
public class StringMethod {
    public static void main(String[] args) {
        System.out.println("a".compareTo("aaa"));
        System.out.println("b".compareTo("a"));
        System.out.println("a".compareTo("b"));
        System.out.println("a".compareTo("ba"));

        test(1, null);
    }

    public static void test(int a, Integer b) {
        System.out.println(a);
        System.out.println(b);
    }
}
