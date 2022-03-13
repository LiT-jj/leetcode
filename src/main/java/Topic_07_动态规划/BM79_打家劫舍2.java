package Topic_07_动态规划;

public class BM79_打家劫舍2 {
    public int rob (int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < dp.length - 1; ++i){
            dp[i] = Math.max((i >= 1 ? dp[i-1] : 0),nums[i] + (i >= 2 ? dp[i - 2] : 0));
        }
        max = dp[dp.length - 2];
        dp = new int[nums.length];
        for (int i = 1; i < dp.length; ++i){
            dp[i] = Math.max(i >= 1 ? dp[i-1] : 0,nums[i] + (i >= 2 ? dp[i - 2] : 0));
        }
        return Math.max(max, dp[nums.length-1]);
    }
}
