package com.wenky.lambda.函数式接口.predicate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @program: design-patterns
 * @description: 筛选用的条件 配合filter使用，自定义入参返回boolean值
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 10:06
 */
public class PredicateTest {
  public static void main(String[] args) {
    //  接口定义入参，返回boolean 调用test()执行方法
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    Predicate<Integer> p1 = i -> i > 5;
    Predicate<Integer> p2 = i -> i < 20;
    Predicate<Integer> p3 = i -> i % 2 == 0;

    // Predicate的and()
    // 取偶数
    List list =
        Arrays.stream(numbers).boxed().filter(p1.and(p2).and(p3)).collect(Collectors.toList());
    System.out.println(list);

    // 取奇数
    List list2 =
        Arrays.stream(numbers)
            .boxed()
            .filter(p1.and(p2).and(p3.negate()))
            .collect(Collectors.toList());
    System.out.println(list2);

    // 测试
    Integer[] a = {1, 2, 3};
    List<Integer> list1 =
        Arrays.stream(a).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    Arrays.stream(list1.toArray(new Integer[0])).forEach(i -> System.out.println(i));
    Arrays.stream(list1.toArray(a)).forEach(i -> System.out.println(i));
    Arrays.stream(a).forEach(i -> System.out.println(i));
  }

  public static void int2Integer(int[] args) {
    // 1 int[] -> Integer[]
    Integer[] integers = Arrays.stream(args).boxed().toArray(Integer[]::new);
    // int[] -> List<Integer>
    List<Integer> list = Arrays.stream(args).boxed().collect(Collectors.toList());
    // List<Integer> -> Integer[]
    Integer[] integer2 = list.toArray(new Integer[0]);
    // 1 Integer[] -> List<Integer>
    List<Integer> list3 = Arrays.stream(integers).collect(Collectors.toList());
    // 2 Integer[] -> List<Integer>
    List<Integer> list4 = Arrays.asList(integers);
    // List<Integer> -> int[]
    int[] args2 = list3.stream().mapToInt(Integer::intValue).toArray();
    // 1 Integer[] -> int[]
    int[] args3 = Arrays.stream(integer2).mapToInt(Integer::intValue).toArray();
  }
}
