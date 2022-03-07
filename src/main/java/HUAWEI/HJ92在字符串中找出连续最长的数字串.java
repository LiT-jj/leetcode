package HUAWEI;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HJ92在字符串中找出连续最长的数字串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            int i = 0;
            int maxLen = 0;
            List<String> list = new LinkedList<String>();
            while(i < str.length()){
                if (justify(str.charAt(i))){
                    int j = i + 1;
                    while(j < str.length() && justify(str.charAt(j))){
                        j++;
                    }
                    if (j - i > maxLen){
                        maxLen = j - i;
                        list.clear();
                        list.add(str.substring(i, j));
                    } else if (j -i == maxLen){
                        list.add(str.substring(i, j));
                    }
                    i = j;
                } else {
                    ++i;
                }
            }
            String res = "";
            for(i = 0; i < list.size(); ++i){
                res += list.get(i);
            }
            System.out.println(String.format("%s,%d",res,maxLen));

        }
    }
    public static boolean justify(char ch){
        if ('0' <= ch && ch <= '9'){
            return true;
        } else {
            return false;
        }
    }
}
