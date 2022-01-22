package HUAWEI;

import java.util.Scanner;

public class HJ15求int型正整数在内存中存储时1的个数 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(Integer.bitCount(num));
    }
}
