package HUAWEI;

import java.util.Scanner;

public class HJ51输出单向链表中倒数第k个结点 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int arr[] = new int[n];
            for (int i = 0 ; i < n; ++i){
                arr[i] = scanner.nextInt();
            }
            int pos = scanner.nextInt();
            if (pos == 0){
                System.out.println(0);
            } else {
                System.out.println(arr[arr.length - pos]);
            }
        }

    }
}
