package com.wenky.stream.Collectors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-10 14:28
 */
public class toMapTest {
  public static void main(String[] args) {
    //
    List<String> stringList = Arrays.asList("Hello", "Java", "JDK", "Android", "Kotlin", "World");
    Map<Integer, String> map =
        stringList.stream()
            .collect(
                Collectors.toMap(
                    String::length, // key
                    str -> str, // value
                    (left, right) -> left, // 去重策略
                    HashMap::new)); // map构造方法
    System.out.println(map);
  }
}
