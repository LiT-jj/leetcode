package HUAWEI;

import java.util.Scanner;

public class HJ76尼科彻斯定理 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            long sum = (long)Math.pow(n,3);
            int a1 = (int)sum/n - (n - 1);
            StringBuilder sb = new StringBuilder(Integer.toString(a1));
            for(int i = 1; i < n; i++){
                a1 = a1 + 2;
                sb.append("+");
                sb.append(a1);
            }
            System.out.println(sb);
        }

    }
}
