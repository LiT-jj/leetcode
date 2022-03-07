package Topic_10_贪心算法;

import java.util.Arrays;

public class BM96_主持人调度 {
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        // write code here
        int[] start = new int[startEnd.length];
        int[] end = new int[startEnd.length];

        for (int i = 0; i < startEnd.length; ++i){
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int j = 0;
        int res = 0;
        for (int i = 0; i < start.length; ++i){
            if (start[i] >= end[j]){
               j++;
            } else {
                res++;
            }
        }
        return res;

    }
}
