package 面试题;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 美团开发3_19 {
    static class Main1{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine()){
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                float sum = 0;
                float currentNum = n;
                for(int i = 0; i < m; ++i){
                    sum += currentNum;
                    currentNum = (float)Math.pow(currentNum, 0.5);
                }
                System.out.println(String.format("%.2f", sum));
            }
        }
    }

    public static class Main2{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Integer> list = new LinkedList<>();
            while(scanner.hasNextLine()){
                int m = scanner.nextInt();
                int n = scanner.nextInt();
                for (int i = m; i <= n; ++i){
                    if (function(i)){
                        list.add(i);
                    }
                }
                if (list.size() == 0){
                    System.out.println("no");
                } else {
                    String res = "";
                    for (Integer i: list){
                        res +=  " " + i;
                    }
                    System.out.println(res.trim());
                }
            }


        }

        private static boolean function(int i) {
            int num1 = i % 10;
            int num2 = i / 10 % 10;
            int num3 = i / 100;
            if (i == num1 * num1 * num1 + num2 * num2 * num2 + num3 * num3 * num3){
                return true;
            }
            return false;
        }
    }
}
