package HUAWEI;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HJ74参数解析 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            List<String> list = new LinkedList<String>();
            int i = 0;
            while(i < str.length()){
                if (str.charAt(i) == '"'){
                    int j = i + 1;
                    while(j < str.length() && str.charAt(j) != '"'){
                        j++;
                    }
                    list.add(str.substring(i+1, j));
                    i = j + 1;
                } else if (str.charAt(i) != ' '){
                   int j = i+1;
                   while(j < str.length() && str.charAt(j) != ' '){
                       j++;
                   }
                   list.add(str.substring(i, j));
                   i = j + 1;
               } else {
                   i++;
               }
            }
            System.out.println(list.size());
            for (String s : list) {
                System.out.println(s);
            }
        }

    }
}
