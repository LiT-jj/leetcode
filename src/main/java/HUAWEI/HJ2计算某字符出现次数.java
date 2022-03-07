package HUAWEI;

import java.util.Scanner;

public class HJ2计算某字符出现次数 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            char ch = in.nextLine().charAt(0);
            int time = 0;
            for (int i = 0; i < str.length(); ++i){
               if (justify(str.charAt(i), ch)){
                   time++;
               }
            }
            System.out.println(time);
        }
    }

    private static boolean justify(char ch1, char ch2) {
        if (ch1 == ch2){
            return true;
        } else if ('a' <= ch1 && ch1 <= 'z' && (ch1 - 32) == ch2){
            return true;
        } else if ('A' <= ch1 && ch1 <= 'Z' && (ch1 + 32) == ch2){
            return true;
        }
        return false;
    }
}
