package HOT100;

import java.util.Arrays;

public class T322零钱兑换 {
    public static void main(String[] args) {
        int[] coins = new int[]{2};
        System.out.println(coinChange(coins, 3));
    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i < amount + 1; ++i){
            int min = Integer.MAX_VALUE;
            for(int coin: coins){
                if(i - coin == 0 || (i - coin > 0 && dp[i -coin] != 0))
                    min = Integer.min(min, dp[i - coin]);
            }
            if(min != Integer.MAX_VALUE)
                dp[i] = min + 1;
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
