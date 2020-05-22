package com.wenky.多线程.可重入锁;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: design-patterns
 * @description: 可重入锁，wait状态时，可被其他线程获取
 * 且在原线程失效
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-15 15:48
 **/
public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService exec = Executors.newFixedThreadPool(4);
        /**
         * 构造方法传入true，初始化公平锁，优先申请的线程会先拿到锁，但是会消耗大量资源，默认非公平锁
         */
        final ReentrantLock lock = new ReentrantLock();
        final Condition con = lock.newCondition();

        final int time = 5;

        final Runnable add = () -> {
            System.out.println(Thread.currentThread().getName() + "Pre " + lock);
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "启动了");
            try {
                /**
                 * 1.若获取锁的线程处于wait状态(已经释放了锁)，锁可被其他线程获取
                 */
                con.await(time, TimeUnit.SECONDS);
                //con.await();
                /**
                 * 2.若获取锁的线程处于sleep状态，锁不能被其他线程获取
                 */
                //Thread.sleep(time * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "Post " + lock.toString());
                lock.unlock();
            }
        };

        for (int index = 0; index < 4; index++) exec.submit(add);

        /**
         * 必须先获取锁才能对其他线程进行唤起操作
         */
        Thread.sleep(1000);
        lock.lock();
        try {
            con.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        exec.shutdown();
    }

}
