package Topic_05_哈希;

import java.util.HashMap;
import java.util.Map;

public class BM50_两数之和 {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; ++i){
            map.put(numbers[i], i + 1);
        }
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; ++i){
            if (map.containsKey(target - numbers[i]) && map.get(target - numbers[i]) != i + 1){
                res[0] = Math.min(i + 1, map.get(target - numbers[i]));
                res[1] = Math.max(i+1, map.get(target - numbers[i]));
                break;
            }
        }
        return res;
    }
}
