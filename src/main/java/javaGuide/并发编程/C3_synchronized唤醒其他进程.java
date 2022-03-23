package javaGuide.并发编程;

public class C3_synchronized唤醒其他进程 {
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

class Data{
    private int num = 0;

    public synchronized void decreate() throws InterruptedException {
        while(num == 0){
            wait();
        }
        this.num --;
        System.out.println(String.format("%s执行了decreate方法，当前num：%d", Thread.currentThread().getName(), num));
        this.notifyAll();
    }

    public synchronized void increate() throws InterruptedException {
        while(num == 1){
            wait();
        }
        this.num ++;
        System.out.println(String.format("%s执行了increate方法，当前num：%d", Thread.currentThread().getName(), num));
        this.notifyAll();
    }
}