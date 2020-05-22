package com.wenky.静态类;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-28 13:43
 **/
public class StaticClass {

    // 外部静态变量和静态代码块按顺序执行
    public static long OUTER_DATE = System.currentTimeMillis();

    static {
        System.out.println("外部静态代码块加载时间:" + System.currentTimeMillis());
    }

    // 只有类被实例化的时候才会调用，每次都执行
    {
        System.out.println("外部构造代码块执行时间:" + System.currentTimeMillis());
    }

    public StaticClass() {
        System.out.println("外部构造函数执行时间:" + System.currentTimeMillis());
    }

    // 静态内部类只有在被调用的时候才加载
    static class InnerStaticClass {
        public static long INNER_DATE = System.currentTimeMillis();

        static {
            System.out.println("内部静态代码块加载时间:" + System.currentTimeMillis());
        }
    }

    // 非静态内部类在类初始化的时候初始化构造方法
    class InnerClass {
        public long INNER_DATE = 0;

        public InnerClass() {
            INNER_DATE = System.currentTimeMillis();
        }
    }

    public static void main(String[] args) {
        // 外部类加载
        // StaticClass staticClass = new StaticClass();

        // 静态内部类加载
        // System.out.println(StaticClass.InnerStaticClass.INNER_DATE);

        // 非静态内部类加载
        // System.out.println(new StaticClass().new InnerClass().INNER_DATE);
    }
}
