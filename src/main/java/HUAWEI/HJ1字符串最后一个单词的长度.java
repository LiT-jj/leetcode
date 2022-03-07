package HUAWEI;

import java.util.Scanner;

public class HJ1字符串最后一个单词的长度 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            String[] words = str.split(" ");
            System.out.println(words[words.length - 1].length());
        }
    }
}
