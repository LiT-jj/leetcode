package HUAWEI;

import java.util.Scanner;

public class HJ10字符个数统计 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] flag = new int[128];
        int sum = 0;
        for(int i = 0; i < str.length(); ++i){

            if(flag[str.charAt(i)] == 0){
                sum ++;
            }
            flag[str.charAt(i)] = 1;
        }
        System.out.println(sum);

    }
}
