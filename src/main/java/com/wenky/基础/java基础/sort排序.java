package com.wenky.基础.java基础;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-07 09:59
 **/
public class sort排序 {
    public void listSort() {
        List<Integer> list = new ArrayList<>();
        // 默认顺序 asc
        list.sort(Integer::compareTo);
        // 倒序 desc
        list.sort(Comparator.comparing(Integer::intValue).reversed());

        // 根据自定义规则比较
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        list.sort(comparator);

        Comparator<Integer> comparator1 = Comparator.comparing(Integer::intValue);
        list.sort(comparator1);

        // 按照int数值排序，如果null排在最前面 倒序
        Comparator<Integer> comparator2 = Comparator.comparing(p -> p.intValue(),
                Comparator.nullsFirst(Integer::compareTo).reversed());
        list.sort(comparator2);

        list.stream().sorted(comparator);

        // 多个比较条件
        Comparator<Integer> comparator3 = Comparator.comparing(Integer::intValue).thenComparing(Integer::compareTo);
        list.sort(comparator3);

        Collections.sort(list, comparator1);
    }
}
