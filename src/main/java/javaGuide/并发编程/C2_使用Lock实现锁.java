package javaGuide.并发编程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C2_使用Lock实现锁 {
    public static void main(String[] args) {
        Ticket_1 ticket_1 = new Ticket_1();
        new Thread(()->{for (int i = 0; i < 1000; ++i) ticket_1.sell(); }, "售卖员A").start();
        new Thread(()->{for (int i = 0; i < 1000; ++i) ticket_1.sell(); }, "售卖员B").start();
        new Thread(()->{for (int i = 0; i < 1000; ++i) ticket_1.sell(); }, "售卖员C").start();
    }
}

class Ticket_1{
    private int num = 1000;

    Lock lock = new ReentrantLock();


    public void sell(){
        lock.lock();
        try {
            if (num > 0){
                num--;
                System.out.println(Thread.currentThread().getName() + "卖出了一张票，当前还剩" + this.num + "张票");
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            lock.unlock();
        }
    }
}