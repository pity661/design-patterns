package com.wenky.多线程.ExecutorService;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-01-16 21:39
 */
public class BlockingQueueTest {
  public static void main(String[] args) throws InterruptedException {
    // 声明一个容量为10的缓存队列
    BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

    Producer producer1 = new Producer(queue);
    Producer producer2 = new Producer(queue);
    Producer producer3 = new Producer(queue);
    Consumer consumer = new Consumer(queue);

    // 借助Executors
    ExecutorService service = Executors.newCachedThreadPool();
    // 启动线程
    service.execute(producer1);
    service.execute(producer2);
    service.execute(producer3);
    service.execute(consumer);

    // 执行10s
    System.out.println(Thread.currentThread().getName());
    Thread.sleep(10 * 1000);
    producer1.stop();
    producer2.stop();
    producer3.stop();
    System.out.println(Thread.currentThread().getName());

    System.out.println("主线程快结束了");
    Thread.sleep(2000);
    // 退出Executor
    service.shutdown();
  }
}
