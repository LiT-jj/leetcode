package Topic_02_二分查找_排序;

public class MB17_二分查找 {
    public static void main(String[] args) {
        int[] nums = new int[]{9};
        System.out.println(search(nums, 8));
    }
    public static int search (int[] nums, int target) {
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
            return mid;
        }
        return -1;
    }
}
