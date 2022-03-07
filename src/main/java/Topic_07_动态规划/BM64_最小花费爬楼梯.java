package Topic_07_动态规划;

public class BM64_最小花费爬楼梯 {
    public int minCostClimbingStairs (int[] cost) {
        // write code here
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; ++i){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[cost.length];
    }
}
