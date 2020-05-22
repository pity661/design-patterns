package com.wenky.多线程.获取执行结果;

import java.util.concurrent.*;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-07-11 14:50
 */
public class CallableFutureTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();

        // 添加任务如果有空余的线程会直接执行
        // <T> Future<T> submit(Callable<T> task);
        Future<Integer> result = executorService.submit(task);
        System.out.println(Thread.currentThread().getName() + "主线程" + System.currentTimeMillis());
        // 不需要再添加任务时执行
        executorService.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程");
        try {
            System.out.println("task运行结果" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println(
                    Thread.currentThread().getName() + "子线程在进行计算" + System.currentTimeMillis());
            Thread.sleep(300000);
            int sum = 0;
            for (int i = 0; i < 100; i++) sum += i;
            return sum;
        }
    }
}
