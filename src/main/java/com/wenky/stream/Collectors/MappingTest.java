package com.wenky.stream.Collectors;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @program: design-patterns
 * @description: 对象分组后按照指定属性组成集合
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-10 15:44
 */
public class MappingTest {
  public static void main(String[] args) {
    //
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5};
    Function<Integer, Boolean> function = i -> i % 2 == 0;

    Map<Boolean, Set<Integer>> map =
        Arrays.stream(numbers)
            .boxed()
            .collect(
                Collectors.groupingBy(
                    function,
                    // xxx 指定属性组成集合
                    Collectors.mapping(Integer::intValue, Collectors.toSet())));
    map.entrySet().stream()
        .map(entry -> String.format("key: %b,value: %s", entry.getKey(), entry.getValue()))
        .forEach(System.out::println);
  }
}
