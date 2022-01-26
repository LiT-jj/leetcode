package HUAWEI;

import java.util.Scanner;

public class HJ67_24点游戏算法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String[] string_name = scanner.nextLine().split(" ");
            int[] nums = new int[4];
            int[] flag = new int[4];
            for (int i = 0; i < nums.length; ++i){
                nums[i] = Integer.valueOf(string_name[i]);
            }
            boolean bool = function(nums, flag, 0.0);
            System.out.println(bool);
        }
    }

    private static boolean function(int[] nums, int[] flag, double num) {
        if (flag[0] + flag[1] + flag[2] + flag[3] == 4 && num == 24.0){
            return true;
        }
        boolean res = false;
        for (int i = 0 ; i < nums.length; ++i){
            if (flag[i] == 0){
                flag[i] = 1;
                if (flag[0] + flag[1] + flag[2] + flag[3] == 1){
                    res = function(nums, flag, nums[i]);
                    if (res){
                        break;
                    }
                } else {
                    res = function(nums, flag, num + nums[i]);
                    if (res){
                        break;
                    }
                    res = function(nums, flag, num - nums[i]);
                    if (res){
                        break;
                    }
                    res = function(nums, flag, num * nums[i]);
                    if (res){
                        break;
                    }
                    res = function(nums, flag, num / nums[i]);
                }
                flag[i] = 0;
            }
        }
        return res;
    }
}
