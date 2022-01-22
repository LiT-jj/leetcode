package javaGuide.新特性;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lambda {

    public static void main(String[] args) {
        自定义函数接口(() -> {
            System.out.println("i am your dady!");
        });

        集合迭代();
    }

    /**
     * 自定义函数接口
     * @param i
     */
    static void 自定义函数接口(LambdaInterface i){
        i.function();
    }

    /**
     * 结合迭代
     */
    static void 集合迭代(){
        List<String> strings = Arrays.asList("1", "2", "3");
        strings.forEach((s) -> {
            System.out.println(s);
        });

        strings.forEach(System.out::println);

        strings.forEach(LambdaClass::staticF);
    }
}


interface LambdaInterface{
    void function();
}

class LambdaClass{
    static LambdaInterface staticF(String s){
        System.out.println(s);
        return null;
    }
}