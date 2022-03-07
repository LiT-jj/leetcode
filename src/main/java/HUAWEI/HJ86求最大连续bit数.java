package HUAWEI;

import java.util.Scanner;

public class HJ86求最大连续bit数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            String str = Integer.toBinaryString(num);
            int i = 0;
            int maxLen = 0;
            while(i < str.length()){
                if (str.charAt(i) == '1'){
                    int j = i + 1;
                    while(j < str.length() && str.charAt(j) == '1'){
                        j++;
                    }
                    if (j - i > maxLen){
                        maxLen = j - i;
                    }
                    i = j;
                }
                i++;
            }
            System.out.println(maxLen);
        }
    }
}
