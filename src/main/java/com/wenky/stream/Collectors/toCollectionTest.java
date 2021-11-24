package com.wenky.stream.Collectors;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-10 13:56
 */
public class toCollectionTest {
  public static void main(String[] args) {
    //
    int[] numbers = {1, 2, 3, 4, 5};
    List<Integer> list =
        Arrays.stream(numbers).boxed().collect(Collectors.toCollection(ArrayList::new));
    // hash
    Set<Integer> set =
        Arrays.stream(numbers).boxed().collect(Collectors.toCollection(HashSet::new));
    // 红黑树
    Set<Integer> set1 =
        Arrays.stream(numbers).boxed().collect(Collectors.toCollection(TreeSet::new));
  }
}
