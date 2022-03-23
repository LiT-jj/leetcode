package 面试题;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 回溯法探究 {
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 8};
        int[] flag = new int[]{0, 0, 0, 0};
        backTracing(arr, flag, 0, 0);
        Collections.sort(list);
        System.out.println(list.size());
    }

    private static void backTracing(int[] arr, int[] flag, int step, int sum) {
        list.add(sum);
        System.out.println(String.format("%d %d %d %d %d",sum, flag[0], flag[1], flag[2], flag[3]));
        if (step == arr.length){
            return;
        }
        for (int i = step;  i < arr.length ; ++i){
            if (flag[i] == 1){
                continue;
            }
            step++;
            flag[i] = 1;
            sum += arr[i];
            backTracing(arr, flag, Math.max(step, i), sum);

            flag[i] = 0;
            sum = sum - arr[i];
            step --;
        }
    }
}
