package com.wenky.基础.java基础.Lambda表达式;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-09 12:58
 **/
public interface NumberInterface {
    int numberOperate(int a, int b);

    // 定义静态默认方法
    static int operate(int a, int b, NumberInterface numberInterface) {
        return numberInterface.numberOperate(a, b);
    }

    // 定义默认方法
    default String getMessage(String message) {
        return "interface" + message;
    }

}
