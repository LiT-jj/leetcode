package Topic_07_动态规划;

public class BM66_最长公共子串 {
    public String LCS (String str1, String str2) {
        // write code here

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int max = 0, maxi = 0, maxj = 0;
        for (int i = 1; i < dp.length; ++i){
            for (int j = 1; j < dp[i].length; ++j){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > max){
                        max = dp[i][j];
                        maxi = i;
                        maxj = j;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(0 <= maxi && 0 <= maxj && dp[maxi][maxj] != 0){
            char ch = str1.charAt(maxi - 1);
            sb.insert(0, ch);
            maxi --;
            maxj --;
        }
        return sb.toString();
    }
}
