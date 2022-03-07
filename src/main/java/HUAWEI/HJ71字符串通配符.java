package HUAWEI;

import java.util.Scanner;

public class HJ71字符串通配符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str1 = scanner.nextLine();
            str1 = str1.replace("***", "*").replace("**", "*");

            String str2 = scanner.nextLine();

            Boolean res = compare(str1, str2, 0, 0);
            System.out.println(res);
        }
    }

    private static Boolean compare(String str1, String str2, int i1, int i2) {
        if (i1 == str1.length() && i2 == str2.length()){
            return true;
        }

        if (i1 < str1.length() && i2 < str2.length()){
            char ch1 = str1.charAt(i1);
            char ch2 = str2.charAt(i2);
            if (justify1(ch1, ch2)){
                return compare(str1, str2, i1+1, i2+1);
            } else if (ch1 == '?' && justify2(ch2)){
                return compare(str1, str2, i1+1, i2+1);
            } else if (ch1 == '*'){
                Boolean res1 = compare(str1, str2, i1+1, i2);
                Boolean res2 = compare(str1, str2, i1+1, i2+1);
                Boolean res3 = compare(str1, str2, i1, i2 + 1);
                return res1 || res2 || res3;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public static boolean justify1(char ch1, char ch2){
        if ('A' <= ch1 && ch1 <= 'Z'){
            ch1 = (char) (ch1 - 'A' + 'a');
        }
        return ch1 == ch2;
    }

    public static boolean justify2(char ch){
        if (('0' <= ch && ch <= '9') || ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')){
            return true;
        }
        return false;
    }
}
