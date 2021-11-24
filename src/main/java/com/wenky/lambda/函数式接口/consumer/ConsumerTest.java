package com.wenky.lambda.函数式接口.consumer;

import java.util.function.Consumer;

/**
 * @program: design-patterns
 * @description: 类似void方法，自定义入参无返回结果
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-10 11:13
 */
public class ConsumerTest {
  public static void main(String[] args) {
    // 接口定义入参，没有出参
    // 调用 accept()方法执行
    Consumer c = p -> System.out.println(p);
    Consumer s = a -> System.out.println(String.format("a: %s", a));
    c.accept("ss");
    s.accept("kk");
  }
}
