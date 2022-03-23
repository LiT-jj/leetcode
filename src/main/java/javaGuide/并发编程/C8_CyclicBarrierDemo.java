package javaGuide.并发编程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class C8_CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, ()->{
            System.out.println("找环神龙~");
        });

        for (int i = 0; i < 7; ++i){
            int finalI = i;
            new Thread(()->{
                System.out.println("收集龙珠：" + finalI);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
