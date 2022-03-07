package HUAWEI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ42学英语 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            function(num);
        }
    }

    /**
     * 关键字：and, billion, million, thousand, hundred
     */
    private static void function(int n) {
        String res = "";
        if (n / 1000000 > 0){
            int num = n / 1000000;
            res = res + " " + function1(num) + " million";
        }
        if (n / 1000 > 0){
            int num = (n % 1000000) / 1000;
            res = res + " " + function1(num) + " thousand";

        }
        if (n % 1000 > 0){
            int num = n % 1000;
            res = res + " " + function1(num);
        }
        System.out.println(res.trim().replace("  ", " "));
    }
    private static String function1(int n){
        Map<Integer, String> single_map = new HashMap<Integer, String>();
        Map<Integer, String> ten_map = new HashMap<Integer, String>();
        int hundred_pos = n / 100;
        int ten_pos = (n % 100) / 10;
        int single_pos = n % 10;
        single_map.put(0, "");ten_map.put(0, "");
        single_map.put(1, "one");ten_map.put(1, "ten");
        single_map.put(2, "two");ten_map.put(2, "twenty");
        single_map.put(3, "three");ten_map.put(3, "thirty");
        single_map.put(4, "four");ten_map.put(4, "forty");
        single_map.put(5, "five");ten_map.put(5, "fifty");
        single_map.put(6, "six");ten_map.put(6, "sixty");
        single_map.put(7, "seven");ten_map.put(7, "seventy");
        single_map.put(8, "eight");ten_map.put(8, "eighty");
        single_map.put(9, "nine");ten_map.put(9, "ninety");
        String res = "";
        String part1 = "";
        String part2 = "";
        String part3 = "";
        if (hundred_pos != 0) {
            part1 = single_map.get(hundred_pos) + " hundred";
        }
        if (ten_pos != 0){
            part2 = ten_map.get(ten_pos);
        }
        if (single_pos != 0){
            part3 = single_map.get(single_pos);
        }
        if (hundred_pos != 0 && (ten_pos != 0 || single_pos !=0)){
            res = part1 + " and " + part2 + " " + part3;
        } else {
            res = part1 + part2 + " " + part3;
        }
        return res.trim();
    }
}
