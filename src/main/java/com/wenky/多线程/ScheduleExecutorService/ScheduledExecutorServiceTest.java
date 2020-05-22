package com.wenky.多线程.ScheduleExecutorService;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: design-patterns
 * @description: 将定时任务与线程池功能结合使用
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-07-11 13:34
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.schedule(
                () -> {
                    stopWatch.stop();
                    System.out.println("我是一只猪" + stopWatch.getTime());
                },
                10,
                TimeUnit.SECONDS);
        scheduledExecutor.shutdown();
    }
}
