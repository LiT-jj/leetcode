package javaGuide.并发编程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C12_threadpool {
    public static void main(String[] args) {
        /*线程池里面只存在一个线程*/
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        /*线程池里面，最多有n个线程执行任务*/
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        /*遇强则强,遇弱则弱*/
        ExecutorService executorService3 = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 15; ++i){
                executorService3.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "执行sout...");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService3.shutdown();
        }

    }

}
