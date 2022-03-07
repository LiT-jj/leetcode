package HUAWEI;

import java.util.Scanner;

public class HJ60查找组成一个偶数最接近的两个素数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            int lower_num = num / 2;
            for (int i = lower_num; i >= 0; --i){
                lower_num = i;
                if (function(lower_num) && function(num - lower_num)){
                    break;
                }
            }
            System.out.println(lower_num);
            System.out.println(num - lower_num);
        }
    }

    private static boolean function(int num) {
        for (int i = num - 1; i > 1; --i){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
