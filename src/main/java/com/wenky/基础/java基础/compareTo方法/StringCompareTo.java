package com.wenky.基础.java基础.compareTo方法;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-04-01 11:42
 **/
public class StringCompareTo {
    public static void main(String[] args) {
        // -2
        System.out.println("111".compareTo("11111"));
        // -1
        System.out.println("21".compareTo("3"));
        // 3
        System.out.println("5".compareTo("2222"));
        //
        System.out.println("蒋".compareTo("胡"));
        // 空指针异常
        System.out.println("".compareTo(null));
    }
    //源码
//    public int compareTo(String anotherString) {
//        int len1 = value.length;
//        int len2 = anotherString.value.length;
//        int lim = Math.min(len1, len2);
//        char v1[] = value;
//        char v2[] = anotherString.value;
//
//        int k = 0;
//        while (k < lim) {
//            char c1 = v1[k];
//            char c2 = v2[k];
//            if (c1 != c2) {
//                return c1 - c2;
//            }
//            k++;
//        }
//        return len1 - len2;
//    }
}
