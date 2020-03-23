package com.wenky.多线程.定时执行;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-07-12 13:46
 **/
public class TimerTest {
  public static void main(String[] args) {
    //
    System.out.println(System.currentTimeMillis());

      Timer timer = new Timer();
    timer.schedule(
        new TimerTask() {
          @Override
          public void run() {
            System.out.println("12321");
          }
        },2000,1000);
  }
}
