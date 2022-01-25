package HUAWEI;

import java.util.Scanner;

public class HJ75公共子串计算 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            int maxLen = 0;
            for (int i = 0; i < str1.length(); ++i){
                for (int j = i+1; j <= str1.length(); ++j){
                    String temp = str1.substring(i, j);
                    if (str2.indexOf(temp) != -1 && temp.length() > maxLen){
                        maxLen = temp.length();
                    }
                }
            }
            System.out.println(maxLen);
        }
    }
}
