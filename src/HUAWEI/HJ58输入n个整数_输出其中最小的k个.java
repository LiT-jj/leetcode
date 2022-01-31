package HUAWEI;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HJ58输入n个整数_输出其中最小的k个 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0 ; i < n; i++){
                arr[i] = scanner.nextInt();
            }
            String res = getMinK(arr, k);
            System.out.println(res);
        }
    }

    private static String getMinK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0 ; i < arr.length; ++i){
            queue.offer(arr[i]);
        }
        String s = "";
        for (int i = 0 ; i < k; ++i){
            s += " " + queue.poll();
        }
        return s.trim();
    }
}
