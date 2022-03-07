package HUAWEI;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ9提取不重复的整数    {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str_num = scanner.nextLine();
        Set<Character> set = new HashSet<Character>();
        for(int i = (str_num.length() - 1); i>= 0; --i){
            if(!set.contains(str_num.charAt(i))){
                System.out.print(str_num.charAt(i));
            }
        }
    }
}
