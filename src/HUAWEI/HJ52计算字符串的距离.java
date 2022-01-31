package HUAWEI;

import java.util.Scanner;

public class HJ52计算字符串的距离 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int[][] dp = new int[str1.length() + 1][str2.length() + 1];
            for (int i = 0; i < dp[0].length; ++i){
                dp[0][i] = i;
            }
            for (int i = 0 ; i < dp.length; ++i){
                dp[i][0] = i;
            }
            for (int i = 1; i < dp.length; ++i){
                for (int j = 1; j < dp[i].length; ++j){
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        int dp1 = dp[i-1][j-1]+1;
                        int dp2 = dp[i-1][j] + 1;
                        int dp3 = dp[i][j-1] + 1;
                        dp[i][j] = Math.min(dp1, Math.min(dp2, dp3));
                    }
                }
            }
            System.out.println(dp[str1.length()][str2.length()]);
        }
    }
}
