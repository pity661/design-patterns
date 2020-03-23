package com.wenky.基础.数据结构.位运算;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-07 10:29
 **/
public class IntegerOperate {

    public static void main(String[] args) {
        integerLeftMove();
    }

    // 左移<<、 右移>>、无符号右移
    public static void integerLeftMove() {
        // 正数
        Integer num = 2;
        printInfo(num);
        num = num << 1;
        printInfo(num);
        num = num >> 1;
        printInfo(num);
        num = num >>> 2;
        printInfo(num);

        // 负数
        Integer num1 = -2;
        printInfo(num1);
        num1 = num1 << 1;
        printInfo(num1);
        num1 = num1 >> 1;
        printInfo(num1);
        num1 = num1 >>> 2;
        printInfo(num1);
        System.out.println(num1);
    }

    public static void printInfo(Integer num) {
      // 负数的补码形式
        System.out.println(Integer.toBinaryString(num));
    }

}
