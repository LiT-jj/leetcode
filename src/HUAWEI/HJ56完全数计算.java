package HUAWEI;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HJ56完全数计算 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int sum = 0;
            for (int i = 1; i <= n; ++i){
                if (function(i)){
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
    static boolean function(int num){
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= num / 2; ++i){
            if(num % i == 0){
                list.add(i);
            }
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum == num;
    }
}
