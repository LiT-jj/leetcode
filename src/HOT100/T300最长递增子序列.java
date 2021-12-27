package HOT100;

public class T300最长递增子序列 {
    static int min = -1;

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
        System.out.println(min);
    }
    public static int lengthOfLIS(int[] nums) {
        for (int i = 0; i < nums.length; ++i){
            backTrack(nums, i, i,1);
        }
        return min;
    }

    public static void backTrack(int[] nums, int start, int flag, int length){
        if(length > min){
            min = length;
        }
        if(start > nums.length - 1){
            return;
        }
        for(int i = start; i < nums.length; ++i){
            if(nums[i] > nums[flag]){
                backTrack(nums, i + 1, i,length + 1);
                backTrack(nums, i + 1, flag, length);
            }
        }
    }
}
