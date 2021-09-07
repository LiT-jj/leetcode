package all;

import java.util.HashMap;

public class T1 {
    public static int[] twoSum(int[] nums, int target){
        for(int i = 0; i < nums.length; ++i){
            for(int j = i+1; j < nums.length; ++j){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; ++i){
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String args[]){
//        int[] nums = {2, 7, 11, 15};
        int[] nums = {3, 2, 4};

        int target = 6;
        int[] result = twoSum1(nums, target);
        System.out.println(result);
    }
}
