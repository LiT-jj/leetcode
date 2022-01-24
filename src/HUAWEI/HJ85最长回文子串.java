package HUAWEI;

import java.util.Scanner;

public class HJ85最长回文子串 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            System.out.println(function(str));
        }
    }

    private static int function(String str) {
        int i = 0;
        int maxLen = 0;
        while(i < str.length()){
            for (int j = i + 1; j <= str.length(); ++j){
                String temp = str.substring(i, j);
                if (justify(temp) && temp.length() > maxLen){
                    maxLen = temp.length();
                }
            }
            ++i;

        }
        return maxLen;

    }

    private static boolean justify(String temp) {
        for (int i = 0; i < temp.length() / 2; ++i){

            if (!(temp.charAt(i) == temp.charAt(temp.length() - i - 1))){
                return false;
            }
        }
        return true;
    }
}
