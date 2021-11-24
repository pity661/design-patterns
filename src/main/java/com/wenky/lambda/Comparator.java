package com.wenky.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-01-09 15:17
 */
public class Comparator {
  public static void main(String[] args) {
    List<Long> list = new ArrayList<>();
    list.add(1l);
    list.add(2l);
    // reversed翻转逆序输出
    // list.sort(java.util.Comparator.comparing(Long::longValue).reversed());
    Collections.sort(
        list,
        new java.util.Comparator<Long>() {
          @Override
          public int compare(Long o1, Long o2) {
            // 返回值为int类型，大于0表示正序，小于0表示逆序
            if (o2 < o1) {
              return -1;
            }
            return 1;
          }
        });
    System.out.println(list.get(0));
    // 两个对象之间比较

    java.util.Comparator<Long> comparator =
        java.util.Comparator.comparing(
            p -> {
              return p.intValue();
            });
    java.util.Comparator<Long> comparator1 = java.util.Comparator.comparing(Long::longValue);

    list.sort(comparator);
    System.out.println(list.get(0));
  }
}
