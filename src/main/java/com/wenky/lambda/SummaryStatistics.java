package com.wenky.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-01-08 20:20
 */
public class SummaryStatistics {

    public static void main(String[] args) {
        List<String> lists = Arrays.asList("1", "2", "3");
        Integer value1 = lists.stream().mapToInt(Integer::parseInt).max().getAsInt();
        System.out.println(value1);
        //    System.out.println(lists.stream().mapToInt(value -> value.intValue()).max().getAsInt());
        //      System.out.println(lists.stream().mapToInt(value -> value.intValue()).min().getAsInt());
        //      System.out.println(lists.stream().mapToInt(value ->
        // value.intValue()).average().getAsDouble());
        //      System.out.println(lists.stream().mapToInt(value -> value.intValue()).sum());
    }
}
