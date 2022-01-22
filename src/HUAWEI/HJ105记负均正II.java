package HUAWEI;

import java.util.Scanner;

public class HJ105记负均正II {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num_fu= 0;
        int num_zheng = 0;
        int sum = 0;
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            if (num < 0){
                num_fu++;
            } else {
                num_zheng++;
                sum += num;
            }
        }
        System.out.println(num_fu);
        if (num_zheng == 0){
            System.out.println(String.format("%.1f", 0.0));
        } else {
            System.out.println(String.format("%.1f", sum*1.0/num_zheng));
        }
    }
}
