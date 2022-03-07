package Topic_02_二分查找_排序;

import java.util.LinkedList;
import java.util.List;

public class BM19_寻找峰值 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement (int[] nums) {
        // write code here
        if (nums.length == 1){
            return 0;
        }
        if (nums.length == 2){
            return nums[0] > nums[1] ? 0 : 1;
        }
        for (int i = 0; i < nums.length; ++i){
            if (i == 0 && nums[i] > nums[1]){
                return 0;
            } else if (i == nums.length - 1 && nums[i] > nums[nums.length - 2]){
                return i;
            } else {
                if (i-1>= 0 && i+1< nums.length && nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                    return i;
                }
            }

        }
        return -1;

    }
}
