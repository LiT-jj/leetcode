package javaGuide.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    MyInvocationHandler(Object target){
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("add执行前。。。");
        Object res = method.invoke(target, args);
        System.out.println("add执行后。。。");
        return res;
    }
}
