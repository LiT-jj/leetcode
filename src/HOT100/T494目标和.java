package HOT100;

public class T494目标和 {

    static int res = 0;
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        findTargetSumWays(a, target);
        System.out.println(res);
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum_nums = 0;
        for(int i = 0; i < nums.length; ++i){
            sum_nums += nums[i];
        }
        int sum_p = (target + sum_nums) / 2;
        if ((target + sum_nums) % 2 == 1)
            return 0;
        method(nums, sum_p, 0);
        return res;
    }
    public static void method(int[] nums, int target, int start){

        if (start > nums.length || (method_1(nums, target, start) == false)){
            return ;
        }
        if (target == 0){
            res++;
            if (start == nums.length){
                return;
            }
        }
        method(nums, target, start + 1);
        method(nums, target - 1, start + 1);
    }
    public static boolean method_1(int[] nums, int target, int start){
        int max = 0;
        if (target == 0)
            return true;
        for(int i = start; i < nums.length; ++i){
            max += nums[i];
            if(max >= target){
                return true;
            }
        }
        return false;
    }
}
