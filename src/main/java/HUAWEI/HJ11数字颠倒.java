package HUAWEI;

import java.util.Scanner;

public class HJ11数字颠倒 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        char[] char_num = String.valueOf(num).toCharArray();
        for(int i = 0 ; i < char_num.length / 2; ++i){
            char temp = char_num[0];
            char_num[0] = char_num[char_num.length -i - 1];
            char_num[char_num.length - 1 - 1] = temp;
        }
        for (int i = 0; i < char_num.length; i++) {
            System.out.print(char_num[i]);
        }
    }
}
