package HUAWEI;

import java.util.Scanner;

public class HJ108求最小公倍数 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int int1= scanner.nextInt();
            int int2= scanner.nextInt();
            System.out.println(int1*int2/methods(int1,int2));
        }
        public static int methods(int int1,int int2){
           if (int1 == int2){
               return int1;
           } else if (int1 > int2){
               return methods(int2, int1 - int2);
           } else {
               return methods(int1, int2 - int1);
           }
        }
}
