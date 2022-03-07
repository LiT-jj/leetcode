package HUAWEI;

import java.util.Scanner;

public class HJ84统计大写字母个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            int num = 0;
            for (int i = 0; i < str.length(); ++i){
                if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z'){
                    num ++;
                }
            }
            System.out.println(num);
        }
    }

}
