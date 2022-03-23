package javaGuide.并发编程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C5_唤醒指定线程 {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(()->{
            try {
                data3.A();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-001").start();

        new Thread(()->{
            try {
                data3.B();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-002").start();

        new Thread(()->{
            try {
                data3.C();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-003").start();
    }
}

class Data3{
    private int flag = 0;
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void A() throws InterruptedException {
        lock.lock();
        try {
            while(flag != 0){
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName() + "执行A~");
            flag = 1;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void B() throws InterruptedException {
        lock.lock();
        try {
            while(flag != 1){
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + "执行B~");
            flag = 2;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void C() throws InterruptedException {
        lock.lock();
        try {
            while(flag != 2){
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName() + "执行C~");
            flag = 0;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
