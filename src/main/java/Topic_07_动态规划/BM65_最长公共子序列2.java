package Topic_07_动态规划;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BM65_最长公共子序列2 {
    public String LCS (String s1, String s2) {
        // write code here
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); ++i){
            for (int j = 0; j < s2.length(); ++j){
                if (s1.charAt(i) == s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        if (dp[s1.length()][s2.length()] == 0){
            return "-1";
        }
        List<Character> list = new LinkedList<>();
        int i = dp.length - 1;
        int j = dp[i].length - 1;
        while(i >= 0){

            int max = dp[i][j];
            while(0 <= j - 1 && max == dp[i][j - 1]){
                j--;
            }
            while(0 <= i-1 && max == dp[i-1][j]){
                i--;
            }
            if (i-1 >= 0){
                list.add(s1.charAt(i-1));
            }
            i = i - 1;
        }
        String res = "";
        Collections.reverse(list);
        for (int k = 0; k < list.size(); ++k){
            res += list.get(k);
        }
        return res;
    }
}
