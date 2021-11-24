package com.wenky.stream.Collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-10 14:05
 */
public class MinByTest {
  public static void main(String[] args) {
    //
    List<String> stringList = Arrays.asList("Hello", "Java", "JDK", "Android", "Kotlin", "World");

    Comparator comparator = Comparator.comparingInt(String::length);
    Comparator comparator1 = Comparator.comparing(String::length);

    Optional<String> optional =
        (Optional<String>) stringList.stream().collect(Collectors.<String>minBy(comparator1));
    System.out.println(optional.get());
  }
}
