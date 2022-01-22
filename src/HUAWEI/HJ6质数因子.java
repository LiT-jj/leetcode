package HUAWEI;

import java.util.Scanner;

public class HJ6质数因子 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            Long num = scanner.nextLong();
            int chushu = 2;
            String res = "";
            while(num != 1){
                while(num % chushu == 0){
                    res += chushu + " ";
                    num = num / chushu;
                    while(num % chushu != 0 && num != 1){
                        chushu++;
                    }
                }
            }
            System.out.println(res.trim());
        }
    }
}
