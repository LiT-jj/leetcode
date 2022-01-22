package HUAWEI;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HJ93数组分组 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int group1 = 0;
            int group2 = 0;
            List<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < n; ++i){
                int num = scanner.nextInt();
                if (num % 5 == 0){
                    group1 += num;
                } else if (num % 3 == 0){
                    group2 += num;
                } else {
                    list.add(num);
                }
            }
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            if ((sum + Math.abs(group1 - group2)) % 2 != 0){
                System.out.println(false);
            } else {
                int sum_a = (sum + Math.abs(group1 - group2)) / 2;
                System.out.println(justify(list, sum_a));
            }

        }
    }

    private static boolean justify(List<Integer> list, int sum_a) {
        if (sum_a == 0 || list.indexOf(sum_a) != -1){
            return true;
        }
        Boolean res = false;
        for (int i =0; i< list.size();++i){
            int num = list.get(i);
            if (num != 0){
                list.set(i, 0);
                res = justify(list, sum_a - num);
                list.set(i, num);
                if (res){
                    break;
                }
            }
        }
        return res;
    }
}
