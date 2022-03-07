package HUAWEI;

import java.util.Scanner;

public class HJ106字符逆序 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] char_str = str.toCharArray();
        for(int i = 0; i < char_str.length / 2; ++i){
            char temp = char_str[i];
            char_str[i] = char_str[char_str.length - i - 1];
            char_str[char_str.length - i -1] = temp;
        }
        for(int i = 0; i < char_str.length; ++i){
            System.out.print(char_str[i]);
        }
    }
}
