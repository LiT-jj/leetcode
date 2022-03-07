package HUAWEI;

import java.util.*;

public class HJ41称砝码 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n  = scanner.nextInt();
            int[] m = new int[n];
            int[] x = new int[n];
            Set<Integer> set = new HashSet<>();
            set.add(0);
            for (int i = 0; i < m.length; ++i){
                m[i] = scanner.nextInt();
            }
            for (int j = 0 ; j < x.length; ++j){
                x[j] = scanner.nextInt();
            }
            for (int i = 0; i < n; ++i){
                ArrayList<Integer> list = new ArrayList<>(set);
                for (int j = 0; j < list.size(); ++j){
                    for (int k = 1 ; k <= x[i]; ++k){
                        set.add(list.get(j) + m[i] * k);
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}
