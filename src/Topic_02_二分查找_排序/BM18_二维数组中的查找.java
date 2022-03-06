package Topic_02_二分查找_排序;

public class BM18_二维数组中的查找 {
    public boolean Find(int target, int [][] array) {
        for (int i = 0; i < array.length; ++i){
            if (find(array[i], target)){
                return true;
            }
        }
        return false;
    }

    public boolean find(int[] nums, int target){
        int left = 0, right = nums.length - 1, mid = (left + right) / 2;
        while(left < right && 0 <= mid && mid < nums.length && nums[mid]!= target){
            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        if (0 <= mid && mid < nums.length && nums[mid] == target){
            return true;
        }
        return false;
    }
}
