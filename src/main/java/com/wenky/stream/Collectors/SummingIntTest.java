package com.wenky.stream.Collectors;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-10 13:24
 */
public class SummingIntTest {
    public static void main(String[] args) {
        //
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(numbers).boxed().collect(Collectors.summingInt(Integer::intValue));
        int sum1 = Arrays.stream(numbers).sum();
        System.out.println(sum);

        Function<Integer, Boolean> function = i -> i % 2 == 0;
        // 按照奇偶分组并求出各组总和
        Map<Boolean, Integer> map =
                Arrays.stream(numbers)
                        .boxed()
                        .collect(Collectors.groupingBy(function, Collectors.summingInt(Integer::intValue)));
        map.entrySet().stream()
                .map(entry -> String.format("key: %b,value: %s", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);
    }
}
