package com.wenky.lambda;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-21 15:36
 **/
public class Reduce {

    public static void sortReduce() {
        int min = Stream.of(1, 2, 3).min(Comparator.comparing(Integer::intValue)).get();
        System.out.println("min:" + min);
    }

    public static void reduceCount() {
        int count = Stream.of(1, 2, 3).reduce(0, (a, b) -> a + b);
        System.out.println("sum:" + count);
    }

    public static void reduceSummary() {
        IntSummaryStatistics summaryStatistics = Stream.of(1, 2, 3, 4).mapToInt(a -> a).summaryStatistics();
        System.out.printf("Max:%d,Min:%d,Ave:%.2f,Sum:%d", summaryStatistics.getMax(), summaryStatistics.getMin(),
                summaryStatistics.getAverage(), summaryStatistics.getSum());
    }

    public static void main(String[] args) {
        // 排序去最小值
        sortReduce();

        // 累加
        reduceCount();

        reduceSummary();
    }
}
