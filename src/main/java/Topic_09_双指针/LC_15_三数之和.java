package Topic_09_双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC_15_三数之和 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i){
            for (int j = i + 1; j < nums.length; ++j){
                for (int k = nums.length; k > j; --k){
                    if (nums[i] + nums[j] + nums[k] < 0){
                        break;
                    } else if (nums[i] + nums[j] + nums[k] == 0){
                        ArrayList list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
}
