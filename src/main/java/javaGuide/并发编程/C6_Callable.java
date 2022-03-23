package javaGuide.并发编程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class C6_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask<String> task = new FutureTask<>(myThread);

        new Thread(task).start();
        String res = task.get();
        System.out.println(res);
    }

}

class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("执行了Mythread 中的 call 方法");
        return String.valueOf(1024);
    }
}
