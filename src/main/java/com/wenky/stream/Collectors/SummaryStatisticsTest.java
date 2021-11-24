package com.wenky.stream.Collectors;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-10 14:22
 */
public class SummaryStatisticsTest {
  public static void main(String[] args) {
    //

    List<String> stringList = Arrays.asList("Hello", "Java", "JDK", "Android", "Kotlin", "World");
    // 对整数进行操作的类
    IntSummaryStatistics summaryStatistics =
        stringList.stream().collect(Collectors.summarizingInt(String::length));

    System.out.println(summaryStatistics.getMax());
    System.out.println(summaryStatistics.getAverage());
  }
}
