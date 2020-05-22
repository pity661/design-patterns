package com.wenky.lambda.函数式接口.function;

import java.util.function.Function;

/**
 * @program: design-patterns
 * @description: 定义方法参数中传递方法
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 10:55
 */
public class FunctionTest {
    public static void main(String[] args) {
        //  接口规定入参和出参，调用apply方法获取结果
        Function<Integer, Integer> test1 = i -> i + 1;
        Function<Integer, Integer> test2 = i -> i * i;

        System.out.println(calculate(test1, 1));
        System.out.println(calculate(test2, 2));

        // 先执行test2在执行test1
        System.out.println(calculate(test1.compose(test2), 2));

        // 先执行test1在执行test2
        System.out.println(calculate(test1.andThen(test2), 2));
    }

    public static Integer calculate(Function<Integer, Integer> test, Integer number) {
        return test.apply(number);
    }
}
