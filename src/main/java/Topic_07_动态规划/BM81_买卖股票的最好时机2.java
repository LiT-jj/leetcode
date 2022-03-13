package Topic_07_动态规划;

public class BM81_买卖股票的最好时机2 {
    public int maxProfit (int[] prices) {
        // write code here
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; ++i){
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
