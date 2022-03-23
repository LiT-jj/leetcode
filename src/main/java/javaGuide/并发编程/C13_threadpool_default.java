package javaGuide.并发编程;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class C13_threadpool_default {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                100,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                /**
                 * AbortPolicy() 等待队列已满，采用直接抛弃策略
                 * CallerRunsPolicy() 当main调用线程的时候,发现等待队列已满,则让main直接运行任务
                 * DiscardOldestPolicy() 当任务队列已满，则把等待队列中最早的任务丢弃，执行当前任务
                 * DiscardPolicy() 当任务队列已满，则直接丢弃任务
                 */
                new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0 ; i < 100; ++i){
            executor.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "~");
            });
        }
    }
}
