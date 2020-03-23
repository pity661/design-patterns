package com.wenky.lambda;

import java.util.stream.Stream;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-22 09:51
 **/
public class Distinct {

    public static void distinct() {
    Stream.of("1", "2", "3", "4", "1").distinct().forEach(s -> System.out.println(s));
    }

}
