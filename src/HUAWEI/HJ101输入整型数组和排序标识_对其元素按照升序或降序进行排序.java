package HUAWEI;

import java.util.Random;
import java.util.Scanner;

public class HJ101输入整型数组和排序标识_对其元素按照升序或降序进行排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; ++i) {
            arr[i] = scanner.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        int flag = scanner.nextInt();
        String str = "";
        for (int i = 0; i < arr.length; ++i) {
            if (flag == 0) {
                str += arr[i] + " ";
            } else {
                str += arr[arr.length - 1 - i] + " ";
            }
        }
        System.out.println(str);

    }

    public static void quickSort(int[] nums, int left, int right){
        if (left > right){
            return ;
        }
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex+1, right);
    }

    private static int randomPartition(int[] nums, int left, int right) {
        Random random = new Random();
        int randomNum = random.nextInt(right - left + 1) + left;
        swap(nums, randomNum, right);
        return partition(nums, left, right);

    }

    private static void swap(int[] nums, int randomNum, int right) {
        int temp = nums[randomNum];
        nums[randomNum] = nums[right];
        nums[right] = temp;
    }

    private static int partition(int[] nums, int left, int right) {
        int x = nums[right];
        int i = left;
        for (int j = left; j <= right; ++j){
            if (nums[j] < x){
                swap(nums, i++, j);
            }
        }
        swap(nums, right, i);
        return i;
    }
}
