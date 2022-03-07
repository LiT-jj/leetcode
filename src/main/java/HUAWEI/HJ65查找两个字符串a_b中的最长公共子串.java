package HUAWEI;

import java.util.Scanner;

public class HJ65查找两个字符串a_b中的最长公共子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            String maxPublicString = "";
            String shorter_string = str1.length() < str2.length() ? str1 : str2;
            String longer_string = str1.length() > str2.length() ? str1 : str2;
            for (int i = 0; i < shorter_string.length(); ++i){
                for (int j = i + 1 ; j <= shorter_string.length(); ++j){
                    String temp = shorter_string.substring(i, j);
                    if (longer_string.indexOf(temp) != -1 && temp.length() > maxPublicString.length()){
                        maxPublicString = temp;
                    }
                }

            }
            System.out.println(maxPublicString);
        }
    }
}
