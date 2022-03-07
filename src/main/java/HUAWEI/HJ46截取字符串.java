package HUAWEI;

import java.util.Scanner;

public class HJ46截取字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            int len = Integer.valueOf(str2);
            System.out.println(str1.substring(0, len));
        }
    }
}
