package HOT100;

public class T416分割等和子集 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition1(nums));
    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        int col = sum / 2;
        int[][] dp = new int[nums.length][col];
        dp[0][nums[0]] = 1;
        for(int i = 1; i < nums.length; ++i){
            for(int j = 1; j < col; ++j){
                int l = j - nums[i] > 0 ? j - nums[i] : 0;
                int r = j + nums[i] < col ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }
        return dp[nums.length - 1][col - 1] >= 1 ? true : false;
    }

    public static boolean canPartition1(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if(sum % 2 != 0) return false;//整数相加不可能得小数
        int W = sum / 2;//相当于背包总承重
        int [] dp = new int[W+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] += dp[i-num];
            }
        }
        return dp[W] != 0;
    }
}
