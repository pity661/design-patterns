package com.wenky.集合类.map类.hashMap数扩容;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-01-03 14:51
 */
public class MainTest {
  public static void main(String[] args) {
    Map<String, String> s = new ConcurrentHashMap<>();

    Map<MapKey, String> map = new HashMap<>();

    // 第一阶段
    for (int i = 0; i < 6; i++) {
      map.put(new MapKey(String.valueOf(i)), "A");
    }
    System.out.println(map.entrySet());

    // 第二阶段
    for (int i = 0; i < 10; i++) {
      map.put(new MapKey(String.valueOf(i)), "A");
    }

    // 第三阶段
    for (int i = 0; i < 50; i++) {
      map.put(new MapKey(String.valueOf(i)), "A");
    }

    // 第四阶段
    map.put(new MapKey("X"), "B");
    map.put(new MapKey("Y"), "B");
    map.put(new MapKey("Z"), "B");

    System.out.println(map);
  }
}
