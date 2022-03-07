package HUAWEI;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ81字符串字符匹配 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String shorterString = scanner.nextLine();
            String longerString = scanner.nextLine();
            Set<Character> set = new HashSet<Character>();
            for(int i = 0; i < longerString.length(); ++i){
                set.add(longerString.charAt(i));
            }
            Boolean res = true;
            for(int i = 0; i < shorterString.length();++i){
                if(set.add(shorterString.charAt(i))){
                    res = false;
                }
            }
            System.out.println(res);
        }
    }
}
