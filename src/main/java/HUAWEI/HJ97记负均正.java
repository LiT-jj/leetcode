package HUAWEI;

import java.util.Scanner;

public class HJ97记负均正 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int num_fu= 0;
            int num_zheng = 0;
            int sum = 0;
            int n = scanner.nextInt();
            for (int i =0; i < n; ++i){
                int num = scanner.nextInt();
                if (num < 0){
                    num_fu++;
                } else if (num > 0){
                    num_zheng++;
                    sum += num;
                }
            }
            if (num_zheng == 0){
                System.out.println(String.format("%d %.1f",num_fu,0.0));
            } else {
                System.out.println(String.format("%d %.1f",num_fu,sum*1.0/num_zheng));
            }
        }
    }
}
