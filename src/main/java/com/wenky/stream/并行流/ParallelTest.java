package com.wenky.stream.并行流;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-31 17:44
 */
public class ParallelTest {

  /**
   * 最慢
   *
   * @param list
   * @return
   */
  public static int baseSumInt(List<Integer> list) {
    return list.stream().mapToInt(i -> i).sum();
  }

  /**
   * 最快
   *
   * @param list
   * @return
   */
  public static int sumInt(List<Integer> list) {
    return list.parallelStream().mapToInt(i -> i).sum();
  }

  /**
   * 初始值必须是0,否则结果不准确
   *
   * @param list
   * @return
   */
  public static int sumInteger(List<Integer> list) {
    return list.parallelStream().reduce(0, (a, b) -> a += b);
  }

  /**
   * 慢
   *
   * @param list
   * @return
   */
  public static List<Integer> baseSort(List<Integer> list) {
    return list.stream().sorted().collect(Collectors.toList());
  }

  /**
   * 快
   *
   * @param list
   * @return
   */
  public static List<Integer> sort(List<Integer> list) {
    return list.parallelStream().sorted().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 100000; i++) {
      list.add(i);
    }

    long start = System.currentTimeMillis();
    System.out.println(baseSumInt(list));
    long end = System.currentTimeMillis();
    System.out.println("baseSumInt:" + (end - start));

    long start1 = System.currentTimeMillis();
    System.out.println(sumInt(list));
    long end1 = System.currentTimeMillis();
    System.out.println("sumInt:" + (end1 - start1));

    long start2 = System.currentTimeMillis();
    System.out.println(sumInteger(list));
    long end2 = System.currentTimeMillis();
    System.out.println("sumInteger:" + (end2 - start2));

    Collections.shuffle(list);
    long start3 = System.currentTimeMillis();
    baseSort(list);
    long end3 = System.currentTimeMillis();
    System.out.println("baseSort:" + (end3 - start3));

    Collections.shuffle(list);
    long start4 = System.currentTimeMillis();
    sort(list);
    long end4 = System.currentTimeMillis();
    System.out.println("sort:" + (end4 - start4));
  }
}
