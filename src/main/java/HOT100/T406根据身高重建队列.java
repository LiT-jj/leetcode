package HOT100;

import java.util.*;

public class T406根据身高重建队列 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] b = reconstructQueue(a);
        System.out.println(b);
    }

    public static int[][] reconstructQueue(int[][] people){
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]){
                    return 1;
                } else {
                    if (o1[0] == o2[0]){
                        return o2[1] - o1[1];
                    }
                    return -1;
                }
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        int[][] b = new int[people.length][2];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < b.length; ++i){
            list.add(i);
        }
        for (int i = 0; i < b.length; ++i){
            b[list.get(people[i][1])] = people[i];
            list.remove(list.get(people[i][1]));
        }
        return b;
    }
}
