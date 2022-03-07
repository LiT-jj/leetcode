package HOT100;

public class T581最短无序子数组 {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 4}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        if(nums.length <= 1)
            return 0;
        int len = nums.length, min = nums[len - 1], max  = nums[0];
        int left = len - 1, right = 0;
        for(int i = 1; i < len; ++i){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - i -1]);
            if(nums[i] < max) right = i;
            if(nums[len - 1 - i] > min) left = len - i - 1;

        }
        return right > left ? right - left + 1 : 0;
    }
}
