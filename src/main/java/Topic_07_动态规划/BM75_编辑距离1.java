package Topic_07_动态规划;

public class BM75_编辑距离1 {
    public int editDistance (String str1, String str2) {
        // write code here
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length;++i){
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length;++i){
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; ++i){
            for (int j = 1; j < dp[i].length; ++j){
                char ch1 = str1.charAt(i-1);
                char ch2 = str2.charAt(j-1);
                if (ch1 == ch2){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int update_num = dp[i-1][j-1] + 1;
                    int delete_num = dp[i][j-1] + 1;
                    int insert_num = dp[i-1][j] + 1;
                    dp[i][j] = Math.min(update_num, Math.min(delete_num, insert_num));
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
