package HOT100;

import java.util.*;

public class T347前k个高频元素 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, -1, 2, -1, 2, 3};
        System.out.println(topKFrequent(nums, 2));
        System.out.println(topKFrequent_heap(nums, 2));

        System.out.println(Integer.bitCount(2));
        LinkedList<Integer> a = new LinkedList<Integer>();
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; ++i){
            int key = nums[i];
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        int[] number = new int[k];
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < list.size() && i < k; ++i){
            number[i] = list.get(i).getKey();
        }
        return number;
    }

    /**
     * 堆排序
     * @return
     */
    public static int[] topKFrequent_heap(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
              return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if (priorityQueue.size() < k){
                priorityQueue.add(new int[]{key, value});
            } else {
                if (priorityQueue.peek()[1] < value){
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{key, value});
                }
            }
        }
        int[] res = new int[k];
        int i = 0;
        while(!priorityQueue.isEmpty()){
            res[i++] = priorityQueue.poll()[0];
        }
        return res;
    }

    /**
     * 快速排序
     * @return
     */
    public static int[] topKFrequnet_quicksort(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            arrayList.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[]{};
        int left = 0, right = arrayList.size();
        quicksort(arrayList, res, left, right, k);
        return res;
    }

    private static void quicksort(ArrayList<int[]> arrayList, int[] res, int left, int right, int k) {
        int i = left;
        int j = right;
        int temp = arrayList.get(left)[1];
        while(i < j && i < arrayList.size() - 1){
            while( j > i && arrayList.get(--j)[1] > temp);
            Collections.swap(arrayList, i, j);
            while(j > i && arrayList.get(++i)[1] < temp);
            Collections.swap(arrayList, i, j);
            Collections.swap(arrayList, i, j);
        }
    }
}
