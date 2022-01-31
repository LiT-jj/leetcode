package HUAWEI;

import java.util.Scanner;

public class HJ40统计字符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            int len_num = 0;
            int len_word = 0;
            int len_space = 0;
            int len_other = 0;
            for (int i = 0; i < str.length(); ++i){
                char ch = str.charAt(i);
                if ('0' <= ch && ch <= '9'){
                    len_num ++;
                } else if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')){
                    len_word ++;
                } else if (ch == ' '){
                    len_space ++;
                } else {
                    len_other ++;
                }
            }
            System.out.println(len_word);
            System.out.println(len_space);
            System.out.println(len_num);
            System.out.println(len_other);
        }
    }
}
