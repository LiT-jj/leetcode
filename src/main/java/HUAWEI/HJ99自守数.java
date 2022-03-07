package HUAWEI;

import java.util.Scanner;

public class HJ99自守数 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] dp = new int[10001];
        dp[0] = 1;
        int curLen = 1;
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            for(int i = curLen; i <= num; ++i){
                dp[i] = dp[i-1] + isZiShouShu(i);
            }
            System.out.println(dp[num]);
        }

    }

    public static int isZiShouShu(int num){
        String string_num = String.valueOf(num);
        String string_num1 = String.valueOf(num*num);
        if(string_num1.endsWith(string_num)){
            return 1;
        } else {
            return 0;
        }
    }
}
