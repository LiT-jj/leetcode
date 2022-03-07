package HUAWEI;

import java.util.*;

public class HJ77火车进站 {
    static List<String> list = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] train = new int[n];
            for (int i = 0; i < n; ++i){
                train[i] = scanner.nextInt();
            }
            Stack<Integer> stack = new Stack<Integer>();
            function(train, stack, 0,  "");
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    for (int i = 0; i < o1.length(); ++i){
                        if (o1.charAt(i) > o2.charAt(i)){
                            return 1;
                        } else if (o1.charAt(i) < o2.charAt(i)){
                            return -1;
                        }
                    }
                    return 0;
                }
            });
            for (int i = 0 ; i < list.size(); ++i){
                System.out.println(list.get(i));
            }
        }
    }
    private static void function(int[] train, Stack<Integer> stack, int no_train, String pop_seq) {
        if (no_train >= train.length && stack.isEmpty()){
            list.add(pop_seq.trim());
            return;
        }
        //火车出站
        if (!stack.isEmpty()){
            int train_no = stack.pop();
            function(train, stack, no_train, pop_seq + " " + train_no);
            stack.push(train_no);
        }
        //火车进站
        if (no_train < train.length){
            stack.push(train[no_train]);
            function(train, stack, no_train+1, pop_seq);
            stack.pop();
        }
    }

}
