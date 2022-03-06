package Topic_05_哈希;

import java.util.HashMap;
import java.util.Set;

public class BM51_数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; ++i){
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        Set<Integer> set = map.keySet();
        for(Integer key: set){
            if (map.get(key) > array.length / 2){
                return key;
            }
        }
        return -1;
    }
}
