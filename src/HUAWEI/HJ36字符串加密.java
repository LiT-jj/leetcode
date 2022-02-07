package HUAWEI;

import java.util.Locale;
import java.util.Scanner;

public class HJ36字符串加密 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String key = scanner.nextLine();
            String context = scanner.nextLine();
            String context_lower_case = context.toLowerCase(Locale.ROOT);
            String new_word_table = function(key);
            String password = "";
            for (int i = 0; i < context.length(); ++i){

                char ch = context_lower_case.charAt(i);
                int num = ch - 'a';
                if (Character.isLowerCase(ch)){
                    password = password + new_word_table.charAt(num);
                } else {
                    password = password + Character.toUpperCase(new_word_table.charAt(num));
                }
            }
            System.out.println(password);
        }
    }

    private static String function(String key) {
        key = key.toLowerCase();
        char[] ch = new char[26];
        String res = "";
        for (int i = 0; i < key.length(); ++i){
            char word = key.charAt(i);
            if (ch[word - 'a'] == 0){
                res = res + word;
                ch[word - 'a'] = 1;
            }
        }
        for (int i = 0; i < ch.length; ++i){
            if (ch[i] == 0){
                int char_num = i + 'a';
                res = res + (char)char_num;
            }
        }
        return res;
    }
}
