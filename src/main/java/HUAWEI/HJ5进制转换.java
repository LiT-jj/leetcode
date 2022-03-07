package HUAWEI;

import java.util.Scanner;

public class HJ5进制转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            System.out.println(transfer(str));
        }
    }

    private static String transfer(String str) {
        String num = str.substring(2);
        int res = 0;
        for (int i = 0; i < num.length(); ++i){
            int temp = function(num.charAt(i));
            res = 16 * res + temp;
        }

        return String.valueOf(res);
    }

    private static int function(char ch) {
        if ('0' <= ch && ch <= '9'){
            return Integer.valueOf(ch);
        }else{
            return ch - 'A' + 10;
        }
    }
}
