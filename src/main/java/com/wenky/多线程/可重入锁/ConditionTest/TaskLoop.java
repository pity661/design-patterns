package com.wenky.多线程.可重入锁.ConditionTest;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-07-22 17:17
 */
public class TaskLoop {
    private final Lock lock = new ReentrantLock();

    private final Condition addCondition = lock.newCondition();

    private final Condition subCondition = lock.newCondition();

    private static int num;

    private List<String> list = new LinkedList<>();

    public void add() {
        do {
            System.out.println("add获取锁");
            try {
                lock.tryLock(3, TimeUnit.SECONDS);
                if (list.size() == 2) {
                    // 线程一直等着，直到被通知激活
                    // 到这一步已经释放锁了，锁可以被其他线程获取
                    addCondition.awaitNanos(1000);
                    this.subCondition.signal();
                    continue;
                }
                num++;
                list.add("add " + num);
                System.out.println("List size :" + list.size());
                System.out.println("TreadName:" + Thread.currentThread().getName());
                System.out.println("===========");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } while (true);
    }

    public void sub() {
        do {
            System.out.println("sub获取锁");
            try {
                lock.tryLock(3, TimeUnit.SECONDS);
                if (list.size() == 0) {
                    subCondition.awaitNanos(1000);
                    this.addCondition.signal();
                    continue;
                }
                String s = list.remove(0);
                System.out.println("List first one is :" + s);
                System.out.println("TreadName:" + Thread.currentThread().getName());
                System.out.println("===========");
                num--;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } while (true);
    }

    public static class AddThread implements Runnable {
        private TaskLoop task;

        public AddThread(TaskLoop task) {
            this.task = task;
        }

        @Override
        public void run() {
            task.add();
        }
    }

    public static class SubThread implements Runnable {
        private TaskLoop task;

        public SubThread(TaskLoop task) {
            this.task = task;
        }

        @Override
        public void run() {
            task.sub();
        }
    }
}
