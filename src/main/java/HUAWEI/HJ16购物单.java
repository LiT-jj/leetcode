package HUAWEI;

import java.util.Scanner;

public class HJ16购物单 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] money_and_num = scanner.nextLine().split(" ");
        int money = Integer.valueOf(money_and_num[0]);
        int num = Integer.valueOf(money_and_num[1]);
        int[][] v = new int[num][3];
        int[][] p = new int[num][3];
        int num_of_main = 0;
        for(int i = 0; i < num; ++i){
            String[] v_p_q = scanner.nextLine().split(" ");
            int v_ = Integer.valueOf(v_p_q[0]);
            int p_ = Integer.valueOf(v_p_q[1]);
            int q_ = Integer.valueOf(v_p_q[2]);
            if(q_ == 0){
                v[num_of_main][0] = v_;
                p[num_of_main][0] = p_;
                num_of_main++;
            } else {
                int j = 1;
                while(v[q_-1][j] != 0){j++;}
                v[q_-1][j] = v_;
                p[q_-1][j] = p_;
            }
        }
        int[][] dp = new int[num_of_main + 1][money + 1];
        for (int i = 1; i < dp.length; ++i){
            for (int j = 0; j < dp[i].length; ++j){
                int[] cost = new int[4];
                int[] profit = new int[4];
                cost[0] = v[i-1][0];
                profit[0] = v[i-1][0] * p[i-1][0];

                cost[1] = v[i-1][0] + v[i-1][1];
                profit[1] = v[i-1][0] * p[i-1][0] + v[i-1][1] * p[i-1][1];

                cost[2] = v[i-1][0] + v[i-1][2];
                profit[2] = v[i-1][0] * p[i-1][0] + v[i-1][2] * p[i-1][2];

                cost[3] = v[i-1][1] + v[i-1][2] + v[i-1][0];
                profit[3] = v[i-1][0] * p[i-1][0] + v[i-1][2] * p[i-1][2] + v[i-1][1] * p[i-1][1];
                for (int k = 0; k < 4; ++k){
                    if (j - cost[k] >= 0){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[k]]+profit[k]);
                    }
                }
            }
        }
        System.out.println(dp[num_of_main][money]);
    }
}
