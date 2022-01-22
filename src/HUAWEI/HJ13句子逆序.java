package HUAWEI;

import java.util.Scanner;

public class HJ13句子逆序 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] words = str.split(" ");
        for(int i = 0 ;i < words.length / 2; ++i){
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - i - 1] = temp;
        }
        for(int i = 0; i < words.length; ++i){
            System.out.print(words[i] + " ");
        }
    }
}
