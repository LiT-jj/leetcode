package javaGuide.并发编程;

public class C1_使用synchronized实现锁 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 10000; ++i){
                ticket.sell();
            }
            ticket.sell();
        }, "售货员A").start();

        new Thread(()->{
            for (int i = 0; i < 10000; ++i){
                ticket.sell();
            }
            ticket.sell();
        }, "售货员B").start();

        new Thread(()->{
            for (int i = 0; i < 10000; ++i){
                ticket.sell();
            }
            ticket.sell();
        }, "售货员C").start();

    }
}

class Ticket{
    private int num = 10000;

    public synchronized void sell(){
        if (num > 0){
            num--;
            System.out.println(Thread.currentThread().getName() + "卖出了一张票，当前还剩" + this.num + "张票");
        }
    }
}