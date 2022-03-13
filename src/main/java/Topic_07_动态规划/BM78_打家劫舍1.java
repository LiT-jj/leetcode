package Topic_07_动态规划;

public class BM78_打家劫舍1 {
    public int rob (int[] nums) {
        // write code here
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; ++i){
            dp[i] = Math.max(dp[i-1], nums[i - 1] + dp[i - 2]);
        }
        return dp[nums.length];
    }
}
