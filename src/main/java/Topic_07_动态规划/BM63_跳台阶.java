package Topic_07_动态规划;

public class BM63_跳台阶 {
    public int jumpFloor(int target) {
        int[] dp = new int[target + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= target; ++i){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
}
