package com.wenky.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-03-15 19:12
 */
public class StreamListTest {

  // 创建stream流的方式
  public void createStream() {
    String[] args = new String[] {"hello", "world", "helloworld"};
    // 1
    Stream<String> stream1 = Stream.of(args);
    // 2
    Stream<String> stream2 = Arrays.stream(args);
    // 3
    Stream<String> stream3 = Arrays.asList(args).stream();

    stream3.map(String::toUpperCase).collect(Collectors.toSet());
  }

  public static void main(String[] args) {
    List<String> a = Arrays.asList("1", "2", "3");
    System.out.println(
        a.stream()
            .filter(
                s -> {
                  return s.length() == 2;
                })
            .collect(Collectors.toList())
            .size());
  }
}
