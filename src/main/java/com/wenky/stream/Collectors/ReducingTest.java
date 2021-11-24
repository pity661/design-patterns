package com.wenky.stream.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-10 15:07
 */
public class ReducingTest {
  public static void main(String[] args) {
    //
    List<String> stringList = Arrays.asList("Hello", "Java", "JDK", "Android", "Kotlin", "World");
    // 带初始值字符串拼接
    String str =
        stringList.stream()
            .collect(
                Collectors.reducing(
                    "111", // 初始值
                    (left, right) -> left + right));
    System.out.println(str);

    Optional<String> str1 = stringList.stream().collect(Collectors.reducing((s1, s2) -> s1 + s2));
    System.out.println(str1.get());

    Optional<String> str2 = stringList.stream().collect(Collectors.reducing((s1, s2) -> s1 + s2));
    System.out.println(str1.get());
  }
}
