package com.wenky.基础.java基础.Lambda表达式;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-09 13:01
 **/
public class NumberTest {
  public static void main(String[] args) {
    //
      NumberInterface add = (a,b) -> a + b;

      NumberInterface sub = (int a,int b) -> a - b;

      NumberInterface mul = (a,b) -> a * b;

      NumberInterface div = (a,b) -> {
          return a/b;
      };

      System.out.println("ADD:" + NumberInterface.operate(1,2,add));
      System.out.println("SUB:" + NumberInterface.operate(1,2,sub));
  }
}
