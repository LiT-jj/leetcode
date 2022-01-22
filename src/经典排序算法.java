import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Random;

public class 经典排序算法 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
//        快速排序(nums, 0, nums.length - 1);
        堆排序(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 快速排序
     * @param nums
     * @param left
     * @param right
     */
    private static void 快速排序(int[] nums, int left, int right) {
        if (left <= right){
            int partitionIndex = 随机分区(nums, left, right);
            快速排序(nums, left, partitionIndex-1);
            快速排序(nums, partitionIndex+1, right);
        }
    }
    private static int 随机分区(int[] nums, int left, int right) {
        Random random = new Random();
        int randomIndex = random.nextInt(right - left + 1) + left;
        交换(nums, right, randomIndex);
        return 分区(nums, left, right);
    }
    private static int 分区(int[] nums, int left, int right) {
        int temp = nums[right], i = left;
        for(int j = left; j <= right; ++j){
            if (nums[j] < temp){
                交换(nums, i++, j);
            }
        }
        交换(nums, i, right);
        return i;
    }
    private static void 交换(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void 堆排序(int[] nums){
        for (int i = nums.length - 1; i >= 0; i--){
            保持大顶堆(nums, i);
            swap(nums, 0, i);
        }
    }

    private static void 保持大顶堆(int[] nums, int l){
        for (int i = nums.length / 2; i >= 0; i--) {
            int lchildIndex = 2 * i + 1;
            int rchildIndex = 2 * i + 2;
            if (lchildIndex <= l && nums[lchildIndex] > nums[i]){
                swap(nums, i, lchildIndex);
            }
            if (rchildIndex <= l && nums[rchildIndex] > nums[i]){
                swap(nums, i, rchildIndex);
            }
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
