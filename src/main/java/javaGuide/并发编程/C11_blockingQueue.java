package javaGuide.并发编程;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class C11_blockingQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> integers = new ArrayBlockingQueue<Integer>(3);


        /*第一组：add 和 remove*/
        integers.add(1);
        integers.add(2);
        integers.add(3);

        integers.remove();
        integers.remove();
        integers.remove();

        /*第二组：offer vs pop*/
        System.out.println(integers.offer(1));
        System.out.println(integers.offer(2));
        System.out.println(integers.offer(3));
        System.out.println(integers.offer(3));
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());

        /*第三组：put vs take*/
        integers.put(1);
        integers.put(2);
        integers.put(3);

        System.out.println(integers.take());
        System.out.println(integers.take());
        System.out.println(integers.take());

        /*第四组：offer vs poll*/
        System.out.println("超时等待...");
        for (int i = 0; i < 5; ++i){
            int finalI = i;
            new Thread(()->{
                try {
                    integers.offer(finalI, 1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 5; ++i){
            new Thread(()->{
                try {
                    System.out.println(integers.poll(1, TimeUnit.SECONDS));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
