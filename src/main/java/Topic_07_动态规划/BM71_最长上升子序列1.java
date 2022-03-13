package Topic_07_动态规划;

import java.util.Arrays;

public class BM71_最长上升子序列1 {
    public int LIS (int[] arr) {
        // write code here
        int[] dp = new int[arr.length + 1];

        for (int i = 1; i < dp.length; ++i){
            int max = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 1; --j){
                if (arr[i - 1] > arr[j - 1] && dp[j] + 1 > max){
                    max = dp[j] + 1;
                }
            }
            dp[i] = (max == Integer.MIN_VALUE ? 1 : max);
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }
}
