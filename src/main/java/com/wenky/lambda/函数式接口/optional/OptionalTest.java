package com.wenky.lambda.函数式接口.optional;

import java.util.Optional;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-10 11:56
 */
public class OptionalTest {
  public static void main(String[] args) {
    //
    String str = "hello";
    Optional<String> optional = Optional.ofNullable(str);
    optional.ifPresent(s -> System.out.println(s));
  }
}
