package javaGuide.并发编程;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class C9_signal {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);

        for (int i = 0; i < 50; i ++){
            int finalI = i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("顾客"+finalI+"过来剪头发");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("顾客"+finalI+"剪完头发了");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
