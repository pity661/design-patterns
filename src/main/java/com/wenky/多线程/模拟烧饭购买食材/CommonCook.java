package com.wenky.多线程.模拟烧饭购买食材;

/**
 * @program: design-patterns
 * @description: 普通的
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-10-27 11:17
 **/
public class CommonCook {


  public static void main(String[] args) throws InterruptedException {
      long startTime = System.currentTimeMillis(); // 开始时间
      // 第一步 网购厨具
      OnlineShopping thread = new OnlineShopping();

      thread.start();
      /**
       * 串行
       * join的意思是使得放弃当前线程的执行，并返回对应的线程，例如下面代码的意思就是：
       * 程序在main线程中调用t1线程的join方法，则main线程放弃cpu控制权，并返回t1线程继续执行直到线程t1执行完毕
       * 所以结果是t1线程执行完后，才到主线程执行，相当于在main线程中同步t1线程，t1执行完了，main线程才有执行的机会
       *
       * join方法只有在start方法后执行才有效否则会并行
       */
      //thread.join();  // 保证厨具送到
      // 第二步 去超市购买食材
      Thread.sleep(2000);  // 模拟购买食材时间
      Shicai shicai = new Shicai();
      System.out.println("第二步：食材到位");
      // 第三步 用厨具烹饪食材
      System.out.println("第三步：开始展现厨艺");
      cook(thread.chuju, shicai);

      System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
  }

  static class OnlineShopping extends Thread {
      private Chuju chuju;

      @Override
      public void run() {
          System.out.println("第一步：下单");
          System.out.println("第一步：等待送货");
          try {
              Thread.sleep(5000);  // 模拟送货时间
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("第一步：快递送到");
          chuju = new Chuju();
      }
  }

    //  用厨具烹饪食材
    static void cook(Chuju chuju, Shicai shicai) {
    }

    // 厨具类
    static class Chuju {}

    // 食材类
    static class Shicai {}
}
