package com.wenky.stream.Collectors;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-10 16:32
 */
public class CountingTest {
    public static void main(String[] args) {
        //
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // 按照奇偶分组
        Function<Integer, Boolean> function = i -> i % 2 == 0;
        Long count = Arrays.stream(numbers).boxed().collect(Collectors.counting());
        System.out.println(count);
    }
}
