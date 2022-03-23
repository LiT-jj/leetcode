package javaGuide.并发编程;

import java.util.concurrent.CountDownLatch;

public class C7_CountDownlatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; ++i){
            new Thread(()->{countDownLatch.countDown();}, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("结束");
    }
}
