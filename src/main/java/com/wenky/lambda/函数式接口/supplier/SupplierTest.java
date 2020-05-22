package com.wenky.lambda.函数式接口.supplier;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: design-patterns
 * @description: 无入参，用于事先定义结果 调用get()获取结果
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-10 11:01
 */
public class SupplierTest {
    int age = 1;

    SupplierTest() {
        System.out.println(this.age);
    }

    SupplierTest(int age) {
        this.age = age;
        System.out.println(this.age);
    }

    public static void main(String[] args) {
        // 无入参、可用于无参构造方法创建类
        // 事先定义处理结果，等时机成熟调用get()方法获取结果
        Supplier<SupplierTest> sup1 = SupplierTest::new;
        sup1.get();

        Function<Integer, SupplierTest> fun = i -> new SupplierTest(i);
        fun.apply(5);

        Supplier<Integer> sup2 = () -> 1 + 1;
        System.out.println(sup2.get());
    }
}
