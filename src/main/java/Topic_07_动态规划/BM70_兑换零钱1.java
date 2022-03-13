package Topic_07_动态规划;

import java.util.regex.Pattern;

public class BM70_兑换零钱1 {
    public int minMoney (int[] arr, int aim) {
        // write code here
        if (aim == 0){
            return 0;
        }
        int[] dp = new int[aim + 1];
        dp[0] = 0;
        for (int i = 0; i < arr.length; ++i){
            if (arr[i] < dp.length){
                dp[arr[i]] = 1;
            }

        }
        for (int i = 1; i < dp.length; ++i){
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 1; --j){
                if (dp[j] != 0 && dp[i - j] != 0 && dp[j] + dp[i - j] < min){
                    min = dp[i - j] + dp[j];
                }
            }
            if (dp[i] != 1){
                dp[i] = (min == Integer.MAX_VALUE ? dp[i] : min);
            }
        }
        return dp[aim] == 0 ? -1 : dp[aim];
    }
}
