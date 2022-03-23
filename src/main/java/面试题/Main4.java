package 面试题;

import sun.misc.Queue;

import java.util.*;

public class Main4 {

    static int max = Integer.MIN_VALUE;
    static int num = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int k1 = scanner.nextInt();
            int k2 = scanner.nextInt();
            int[] ball = new int[n];
            for (int i = 0; i < n; ++i){
                ball[i] = scanner.nextInt();
            }
            
            int[] flag = new int[n];
            backtracking(ball, flag, k1, k2, 0, 0);
            System.out.println(max + " " + num);
        }
    }

    private static void backtracking(int[] ball, int[] flag, int k1, int k2, int sum, int step) {
        //如果和满足条件
        if (sum % k1 == 0 && sum % k2 != 0){
            //和比当前的最大值大
            if (sum > max){
                num = 1;
                max = sum;
            } else if (sum == max){
                num++;
            }
        }
        if (step == ball.length){
            return;
        }
        for (int i = step; i < ball.length; ++i){
            if (flag[i] == 1){
                continue;
            }
            flag[i] = 1;
            sum += ball[i];
            step ++;
            backtracking(ball, flag, k1, k2, sum, Math.max(i, step));

            //现场恢复
            flag[i] = 0;
            step --;
            sum -= ball[i];
        }
    }


}
