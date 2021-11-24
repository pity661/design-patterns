package com.wenky.文件处理.buffer;

import java.nio.CharBuffer;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky
 * @email: huwenqi@panda-fintech.com
 * @create: 2020-03-23 21:50
 */
public class CharBufferTest {

  CharBuffer charBuffer = CharBuffer.allocate(100);

  // 缓存区的数据元素会存储在数组中，数组和缓存区的变化将互相影响
  //    char [] myArray = new char[100];
  //    CharBuffer charBuffer1 = CharBuffer.wrap(myArray);

  public static void test() {
    char[] myArray = new char[] {'1', '2', '3', '4', '5'};
    CharBuffer charBuffer1 = CharBuffer.wrap(myArray, 2, 2);
    System.out.println(charBuffer1.order().toString());
    // 2
    System.out.println(charBuffer1.length());
    // 可用缓冲区长度 2
    System.out.println(charBuffer1.remaining());
    // 1，2，3，4，5
    System.out.println(myArray);
    // 从缓存区读取数据
    while (charBuffer1.hasRemaining()) {
      // 3，4
      System.out.println(charBuffer1.get());
    }
    // 清空缓存区 仅仅把position指向0，limit指向最大(准备开始写)
    charBuffer1.clear();
    // 往缓存区添加数据
    int i = 0;
    while (charBuffer1.hasRemaining()) {
      charBuffer1.put(String.valueOf(i++));
    }
    // 0，1，2，3，4
    System.out.println(myArray);
    // 把position指向0，limit指向position的位置(准备开始读)
    charBuffer1.flip();
    while (charBuffer1.hasRemaining()) {
      // 0 1 2 3 4
      System.out.println(charBuffer1.get());
    }
  }

  public static void main(String[] args) {
    test();
  }
}
