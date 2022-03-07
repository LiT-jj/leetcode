package HUAWEI;

import java.util.Scanner;

public class HJ62查找输入整数二进制中1的个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            System.out.println(Integer.bitCount(num));
        }
    }
}
