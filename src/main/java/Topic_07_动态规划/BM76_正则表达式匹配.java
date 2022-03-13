package Topic_07_动态规划;

public class BM76_正则表达式匹配 {
    public boolean match (String str, String pattern) {
        // write code here
        int[][] dp = new int[str.length() + 1][pattern.length() + 1];
        dp[0][0] = 1;
        for (int i = 0; i < dp[0].length; ++i){
            if (0<= i-1 && pattern.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i = 1; i < dp.length; ++i){
            for (int j = 1; j < dp[0].length; ++j){
                char ch1 = str.charAt(i-1);
                char ch2 = pattern.charAt(j-1);
                if (ch1 == ch2 || ch2 == '.'){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    if (ch2 != '*'){
                        dp[i][j] = 0;
                    } else {
                        char ch3 = pattern.charAt(j-2);
                        if (ch1 == ch3 || ch3 == '.'){
                            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-2]);
                        } else {
                            dp[i][j] = dp[i][j-2];
                        }
                    }
                }
            }
        }
        return dp[str.length()][pattern.length()] == 1 ? true : false;
    }
}
