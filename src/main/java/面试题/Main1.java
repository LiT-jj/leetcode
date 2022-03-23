package 面试题;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] originPrice = new int[n];
        int[] discountPrice = new int[n];

        for (int i = 0; i < n; ++i){
            originPrice[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; ++i){
            discountPrice[i] = scanner.nextInt();
        }

        //满减规则数
        int m = scanner.nextInt();
        int[] c = new int[m];
        int[] d = new int[m];

        for (int i = 0; i < m; ++i){
            c[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; ++i){
            d[i] = scanner.nextInt();
        }
        int[] sum = new int[n+1];
        sum[0] = 0;

        for (int i = 1; i <= n; i++){
            sum[i] = originPrice[i-1] + sum[i-1];
        }

        int[] discountSum = new int[n+1];
        discountSum[0] = 0;
        for (int i = 1; i <= n; ++i){
            discountSum[i] = discountPrice[i-1] + discountSum[i-1];
        }

        StringBuffer bf = new StringBuffer();
        for (int  i = 1; i <= n; i++){
            if (sum[i] < c[0]){
                if (sum[i] == discountSum[i]){
                    bf.append('B');
                } else if (sum[i] > discountSum[i]){
                    bf.append('Z');
                }
            } else {
                int index = 0;
                while(index < m && sum[i] >= c[index]){
                    index++;
                }
                if ((sum[i]) - d[index - 1] < discountSum[i]){
                    bf.append('M');
                } else if ((sum[i]) - d[index - 1] == discountSum[i]){
                    bf.append('B');
                } else {
                    bf.append('Z');
                }
            }
        }
        System.out.println(bf.toString());
    }
}
