package Topic_07_动态规划;

public class BM62_斐波那契数列 {
    public int Fibonacci(int n) {
        if (n == 1 || n == 2){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i < dp.length; ++i){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
