package com.wenky.静态类;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-10-27 11:43
 **/
public class TestMain {
    public static void main(String[] args) {
        // 外部类直接调用其方法
        new MainInStaticClass().print();
        System.out.println("*******");

        // 静态内部类调用外部类方法
        MainInStaticClass.StaticMain.main();
        new MainInStaticClass.StaticMain().main();
        System.out.println("*******");

        // 非静态内部类调用外部类方法
        // 直接访问外部类的private私有成员变量
        new MainInStaticClass().new CommonMain().main();
    }
}
