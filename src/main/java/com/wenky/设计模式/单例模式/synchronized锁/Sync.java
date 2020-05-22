package com.wenky.设计模式.单例模式.synchronized锁;

/**
 * @program: design-patterns
 * @description: synchronized 锁住的是括号里的对象，不是代码
 * 对于非static的synchronized方法，锁住的就是对象本身也就是this
 * <p>
 * 每次只能一个线程拿到类的实例对象的锁
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-11-23 14:33
 **/
public class Sync {

    public static void main(String[] args) {
        /**
         * 1.同一个对象,锁住的是类的实例对象 ，各个线程顺序运行
         */
        Sync sync = new Sync();
        for (int i = 0; i < 3; i++) {
            /**
             * 1.每个线程都有自己的类的实例对象，所有线程同时运行
             */
            //Sync sync = new Sync();
            Thread thread = new MyThread(sync, i);
            thread.start();
        }
    }

    public synchronized void test(int i) {
        System.out.println("开始" + i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束" + i);
    }

}

class MyThread extends Thread {
    private Sync insync;
    private int ini;

    public MyThread(Sync sync, int i) {
        insync = sync;
        ini = i;
    }

    public void run() {
        // 这里每个线程都new了一个sync类的对象，不是同一个对象所以可以多线程同时运行synchronized方法或代码段
        //  Sync sync = new Sync();
        insync.test(ini);
    }
}



