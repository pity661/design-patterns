package com.wenky.集合类.map类;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-01-14 10:00
 **/
public class TreeMapExplore {
    public static void view() {
        Map<String, String> map = new TreeMap<>();
        map.put("a", "aaa");
        map.put("d", "ddd");
        map.put("b", "bbb");
        map.put("c", "ccc");
        // 三种遍历方式
        // 1.第一种
        map.keySet().stream().forEach(key -> {
            System.out.println("key= " + key + " and value= " + map.get(key));
        });
        // 2.第二种 (推荐)
        map.entrySet().stream().forEach(entry -> {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());

        });
        // 3.第三种
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        // 4.第四种 (只能遍历value，不能遍历key)
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
        map.values().stream().forEach(s -> {
            System.out.println("value= " + s);
        });
    }

    // 按值进行排序
    private static void sort() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("d2", "ddd");
        map.put("b12", "bbb");
        map.put("c2", "ccc");
        System.out.println("map1" + map);
        // 倒序输出
        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
        // Collections.sort(list);
        list.sort((a, b) -> {
            return b.getValue().compareTo(a.getValue());
        });
        list.stream()
                .forEach(
                        s -> {
                            System.out.println("value = " + s);
                            System.out.println("hashcode = " + s.hashCode());
                        });
        System.out.println(list);
        Map<String, String> map2;
        // toMap默认使用hashMap做为初始化对象
        map2 = list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("map2" + map2);
    }

    public static void main(String[] args) {
        // 遍历
        // view();
        // 排序
        sort();
//    System.out.println("AA".hashCode());
//
//    System.out.println(Integer.parseInt("1000000000000000000000000000000",2));
//    System.out.println(1<<30);
//
        System.out.println(-111 >> 2);

        System.out.println(Integer.toBinaryString(-28));

        System.out.println(Integer.parseInt("1111111111111111111111111100100", 2));

        System.out.println(Integer.parseInt("111111111111111111111111111110", 2));

        System.out.println(1 << 2);
        System.out.println(1 >> 2);
        //    System.out.println(Integer.toBinaryString(-1));
        //    Map<String,String> map = new HashMap<>(1,1f);

        System.out.println(1 & 3);
    }
}
