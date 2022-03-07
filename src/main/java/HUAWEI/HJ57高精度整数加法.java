package HUAWEI;

import java.util.Scanner;

public class HJ57高精度整数加法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str1 = "0" + scanner.nextLine();
            String str2 = "0" + scanner.nextLine();
            String shorter_str = str1.length() > str2.length() ? str2 : str1;
            String longer_str = str1.length() <= str2.length() ? str2 : str1;
            if (longer_str.length() - shorter_str.length() > 0){
                while(longer_str.length() > shorter_str.length()){
                    shorter_str = "0" + shorter_str;
                }
            }
            int num = 0;
            String res = "";
            for (int i = shorter_str.length() - 1; i >= 0; --i){
                int num1 = shorter_str.charAt(i) - '0';
                int num2 = longer_str.charAt(i) - '0';
                int sum = num1 + num2 + num;
                num = sum / 10;
                res = sum % 10 + res;
            }
            while(res.startsWith("0") && res.length() > 1){
                res = res.substring(1);
            }
            System.out.println(res);
        }
    }
}
