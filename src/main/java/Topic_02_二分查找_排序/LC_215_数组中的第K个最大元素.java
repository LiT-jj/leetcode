package Topic_02_二分查找_排序;

import java.util.Random;

public class LC_215_数组中的第K个最大元素 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        int res = solution.findKthLargest(arr, k);
        System.out.println(res);
    }
}
/*快速排序*/
class Solution_ {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1,k-1);
    }

    public int quickSort(int[] nums, int left, int right, int k){
        if (left > right){
            return -1;
        }
        int partitionIndex = partition(nums, left, right);
        if (partitionIndex == k){
            return nums[partitionIndex];
        } else if (partitionIndex < k){
            return quickSort(nums, partitionIndex + 1, right, k);
        } else {
            return quickSort(nums, left, partitionIndex - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int index = random.nextInt(right - left + 1) + left;
        swap(nums, right, index);
        int i = left, temp = nums[right];
        for (int j = i; j <= right; ++j){
            if (nums[j] > temp){
                swap(nums, i++, j);
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int index, int right) {
        int temp = nums[index];
        nums[index] = nums[right];
        nums[right] = temp;
    }

}

/*堆排序*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return heapSort(nums, k);
    }

    public int heapSort(int[] nums, int k){
        for (int i = 0; i < k; ++i){
            keepBigHeap(nums, nums.length - i);
            swap(nums, 0, nums.length - 1 - i);
        }
        return nums[nums.length - k];
    }

    public void keepBigHeap(int[] nums, int l){
        for (int i = l / 2; i >= 0; --i){
            int lchild = 2 * i + 1;
            int rchild = 2 * i + 2;
            if (rchild < l){
                int index = nums[lchild] > nums[rchild] ? lchild : rchild;
                if (nums[i] < nums[index]){
                    swap(nums, i, index);
                }
            } else if (lchild < l && nums[i] < nums[lchild]){
                swap(nums, i, lchild);
            }
        }
    }

    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}