package javaGuide.并发编程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C4_Lock唤醒其他进程 {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{for (int i = 0; i < 100; ++i) {
            try {
                data.increate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }, "线程1").start();
        new Thread(()->{for (int i = 0; i < 100; ++i) {
            try {
                data.increate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }, "线程2").start();
        new Thread(()->{for (int i = 0; i < 100; ++i) {
            try {
                data.decreate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }, "线程3").start();
        new Thread(()->{for (int i = 0; i < 100; ++i) {
            try {
                data.decreate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }, "线程4").start();
    }
}

class Data2{
    private int num;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void decreate() throws InterruptedException {
        lock.lock();
        try {
            while(num != 1){
                condition.wait();
            }
            this.num --;
            System.out.println(String.format("%s执行了decreate方法，当前num：%d", Thread.currentThread().getName(), num));
            condition.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void increate() throws InterruptedException {
        lock.lock();
        try {
            while(num != 0){
                condition.wait();
            }
            this.num ++;
            System.out.println(String.format("%s执行了increate方法，当前num：%d", Thread.currentThread().getName(), num));
            condition.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
