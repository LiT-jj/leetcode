package javaGuide.并发编程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class C10_ReadWriteLock {
    public static void main(String[] args) {
        Cache cache = new Cache();
        for (int i = 0; i < 10; ++i){
            int finalI = i;
            new Thread(()->{
                if (finalI % 2 != 0){
                    cache.read();
                } else {
                    cache.write();
                }
            }).start();
        }



    }
    static class Cache{
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        public void read(){
            try {
                reentrantReadWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + "正在读...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "读结束...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantReadWriteLock.readLock().unlock();
            }
        }

        public void write(){
            try {
                reentrantReadWriteLock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + "正在写...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "写结束...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
            }
        }
    }
}
