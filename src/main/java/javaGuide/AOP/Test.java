package javaGuide.AOP;

import javax.xml.ws.Service;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(service);
        UserService service1 = (UserService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(), myInvocationHandler);
        service1.addUser();
    }
}
