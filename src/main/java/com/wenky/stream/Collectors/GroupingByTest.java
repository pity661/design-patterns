package com.wenky.stream.Collectors;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-10 13:32
 */
public class GroupingByTest {
    public static void main(String[] args) {
        //
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // 按照奇偶分组
        Function<Integer, Boolean> function = i -> i % 2 == 0;
        Map<Boolean, List<Integer>> groups =
                Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(function));
        groups.entrySet().stream()
                .map(entry -> String.format("key: %b,value: %s", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);

        // 按照奇偶分组并求出各组总和
        Map<Boolean, Integer> map =
                Arrays.stream(numbers)
                        .boxed()
                        .collect(
                                Collectors.groupingBy(
                                        function,
                                        // xxx 求和操作
                                        Collectors.summingInt(Integer::intValue)));
        map.entrySet().stream()
                .map(entry -> String.format("key: %b,value: %s", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);

        Comparator<Integer> comparator = (i, j) -> i - j;
        // 同
        Comparator comparator1 = Comparator.naturalOrder();

        // 这里设置了类型下面就不需要强制转化了
        BinaryOperator<Integer> binaryOperator = BinaryOperator.maxBy(comparator1);
        // 按照奇偶分组 并找到每组最大的数
        Map<Boolean, Optional<Integer>> map2 =
                // 因为设置了类型不需要强制转化
                (Map<Boolean, Optional<Integer>>)
                        Arrays.stream(numbers)
                                .boxed()
                                .collect(
                                        Collectors.groupingBy(
                                                function,
                                                // xxx 规约操作
                                                Collectors.reducing(binaryOperator)));

        map2.entrySet().stream()
                .map(entry -> String.format("key: %b,value: %s", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);

        // 直接按照boolean进行分组
        Predicate<Integer> predicate = i -> i % 2 == 0;
        Map<Boolean, List<Integer>> groups1 =
                Arrays.stream(numbers)
                        .boxed()
                        .collect(
                                // xxx 按照boolean值分组
                                Collectors.partitioningBy(predicate));
        groups1.entrySet().stream()
                .map(entry -> String.format("key: %b,value: %s", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);

        // 按照奇偶分组并求出各组总和
        Map<Boolean, Integer> map1 =
                Arrays.stream(numbers)
                        .boxed()
                        .collect(
                                Collectors.partitioningBy(predicate, Collectors.summingInt(Integer::intValue)));
        map1.entrySet().stream()
                .map(entry -> String.format("key: %b,value: %s", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);
    }
}
