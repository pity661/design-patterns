package com.wenky.基础.java基础.Lambda表达式;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-09 14:04
 **/
public class StreamTest {
  public static void main(String[] args) {
      Map map = new HashMap();
      map.put("11","aa");
      Object a = new Object();
        a.hashCode();
      Stream<String> stream = Stream.of("1","2","3","4","5");
      stream.distinct();

      Optional<String> s = Optional.ofNullable(null);
      Optional<String> k = Optional.ofNullable(null);
      System.out.println(s.orElse("ss"));
      System.out.println(k.isPresent());
  }
}
