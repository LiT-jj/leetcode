package HUAWEI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ73计算日期到天数转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String[] date = scanner.nextLine().split(" ");
            int year = Integer.valueOf(date[0]);
            int month = Integer.valueOf(date[1]);
            int day = Integer.valueOf(date[2]);
            System.out.println(function1(year, month, day));
        }

    }

    private static int function1(int year, int month, int day) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 31);
        map.put(2, 28);
        map.put(3, 31);
        map.put(4, 30);
        map.put(5, 31);
        map.put(6, 30);
        map.put(7, 31);
        map.put(8, 31);
        map.put(9, 30);
        map.put(10, 31);
        map.put(11, 30);
        map.put(12, 31);
        int res = 0;
        for (int i = 1; i < month; i++){
            res += map.get(i);
        }
        res += day;
        if (month > 2 && function(year)){
            res ++;
        }
        return res;
    }

    public static boolean function(int year){
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return true;
        } else {
            return false;
        }
    }
}
