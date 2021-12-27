package HOT100;

import java.util.*;

public class T621任务调度器 {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
    public static int leastInterval(char[] tasks, int n) {
        int count [] =  new int[26];
        for(int i=0; i < tasks.length; ++i){
            count[tasks[i] - 'A']++;
        }
        Arrays.sort(count);
        for (int i = 0; i < count.length / 2; ++i){
            int temp = count[i];
            count[i] = count[count.length - 1 - i];
            count[count.length - 1 - i] = temp;
        }
        int res = count[0] * n +  1;
        int i = 1;
        while(count[i] == count[0]){
            res++;
            i++;
        }
        return res;
    }
}
