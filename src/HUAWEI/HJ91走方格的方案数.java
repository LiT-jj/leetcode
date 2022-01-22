package HUAWEI;

import java.util.Scanner;

public class HJ91走方格的方案数 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String[] str_num = scanner.nextLine().split(" ");
            int num1 = Integer.valueOf(str_num[0]);
            int num2 = Integer.valueOf(str_num[1]);
            System.out.println(function(num1, num2));
        }
    }

    private static int function(int num1, int num2) {
        if (num1 == 0 || num2 == 0){
            return 1;
        }
        int res1 = function(num1 - 1, num2);
        int res2 = function(num1, num2 - 1);
        return res1 + res2;
    }
}
