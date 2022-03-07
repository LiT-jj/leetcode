package HUAWEI;

import java.util.*;

public class HJ3明明的随机数 {
    static class Input{
        int[] nums;
        Input next;
        Input(int[] nums){
            this.nums = nums;
            this.next = null;
        }
        Input(){};
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new LinkedList<Integer>();
        Input head = new Input();
        Input p = head;
        do {
            int num = in.nextInt();
            int[] nums = new int[num];
            for (int i = 0; i < nums.length; ++i){
                nums[i] = in.nextInt();
            }
            Input input1 = new Input(nums);
            p.next = input1;
            p = p.next;
        } while(in.hasNextInt());
        p = head;
        while(p.next != null){
            p = p.next;
            int[] nums = p.nums;
            quickSort(nums, 0, nums.length - 1);
            int[] new_nums = quchong(nums);
            for (int i = 0; i < new_nums.length; ++i){
                System.out.println(new_nums[i]);
            }
        }
        }


    public static int[] quchong(int[] nums){
        if (nums.length <= 1){
            return nums;
        }
        int i= 0, j = 1;
        while(j < nums.length){
            if (nums[j] == nums[j - 1]){
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }
        int[] new_nums = new int[i+1];
        for (int n = 0; n < new_nums.length; ++n){
            new_nums[n] = nums[n];
        }
        return new_nums;
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
