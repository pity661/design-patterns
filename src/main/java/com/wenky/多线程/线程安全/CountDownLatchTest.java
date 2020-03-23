package com.wenky.多线程.线程安全;

import java.util.concurrent.CountDownLatch;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-10-29 13:59
 **/
public class CountDownLatchTest {
    public static void main(String[] args) {
        final int count = 2;
        final CountDownLatch latch = new CountDownLatch(count);
        // 主要就三个方法
        // latch.await(); // 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
        // latch.await(100L,TimeUnit.SECONDS); // 和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
        // latch.countDown();// 将count值减1

        newThread(latch);

        newThread(latch);

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await(); // 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
            // latch.await(100L,TimeUnit.SECONDS); // 和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void newThread(CountDownLatch latch) {
        /**
         * 实现Runnable创建多线程
         */
//        Thread thread = new Thread(new MyThread(latch));
//        thread.start();

        /**
         * 继承Thread创建多线程
         */
        MyThreadE thread = new MyThreadE(latch);
        thread.start();
    }

    static class MyThread implements Runnable {

        private CountDownLatch latch;

        public MyThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThreadE extends Thread {
        private CountDownLatch latch;

        public MyThreadE(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

