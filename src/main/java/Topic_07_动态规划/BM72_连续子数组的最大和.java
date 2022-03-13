package Topic_07_动态规划;

import java.util.Arrays;

public class BM72_连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 1){
            return array[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; ++i){
            int num1 = array[i];
            int num2 = num1 + array[i-1];
            array[i] = Math.max(num1, num2);
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
}
