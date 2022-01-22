package HUAWEI;

import java.util.Scanner;

public class HJ100等差数列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println((int) (num * 2 + num * (num - 1) * 3 * 0.5) + "");
    }
}
