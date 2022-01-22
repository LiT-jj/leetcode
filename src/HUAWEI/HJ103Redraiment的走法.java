package HUAWEI;

import java.util.Scanner;

public class HJ103Redraiment的走法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            int[] pile = new int[num];
            for (int i = 0 ; i < num; ++i){
                pile[i] = scanner.nextInt();
            }
            int[] dp = new int[num];
            if (num >= 1){
                dp[0] = 1;
                for (int i = 1; i < num; ++i){
                    int max = 0;
                    for (int j = 0; j < i; ++j){
                        if (pile[i] > pile[j] && dp[j] > max){
                            max = dp[j];
                        }
                    }
                    dp[i] = max + 1;
                }
                int max = dp[0];
                for (int i = 1; i < dp.length;++i){
                    if (dp[i] > max){
                        max = dp[i];
                    }
                }
                System.out.println(max);
            } else {
                System.out.println(1);
            }

        }
    }
}
