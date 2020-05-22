package com.wenky.多线程.可重入锁.ConditionTest;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-07-22 15:54
 */
public class Task {
    private final Lock lock = new ReentrantLock();

    private final Condition addCondition = lock.newCondition();

    private final Condition subCondition = lock.newCondition();

    private static int num;

    private List<String> list = new LinkedList<>();

    public void add() {
        lock.lock();
        try {
            if (list.size() == 2) {
                // 线程一直等着，直到被通知激活
                // 到这一步已经释放锁了，锁可以被其他线程获取
                addCondition.await();
                return;
            }
            num++;
            list.add("add " + num);
            System.out.println("List size :" + list.size());
            System.out.println("TreadName:" + Thread.currentThread().getName());
            System.out.println("===========");
            this.subCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void sub() {
        lock.lock();
        try {
            if (list.size() == 0) {
                subCondition.await();
                return;
            }
            String s = list.remove(0);
            System.out.println("List first one is :" + s);
            System.out.println("TreadName:" + Thread.currentThread().getName());
            System.out.println("===========");
            num--;
            this.addCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static class AddThread implements Runnable {
        private Task task;

        public AddThread(Task task) {
            this.task = task;
        }

        @Override
        public void run() {
            task.add();
        }
    }

    public static class SubThread implements Runnable {
        private Task task;

        public SubThread(Task task) {
            this.task = task;
        }

        @Override
        public void run() {
            task.sub();
        }
    }
}
