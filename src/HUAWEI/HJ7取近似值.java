package HUAWEI;

import java.util.Scanner;

public class HJ7取近似值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            String[] nums = str.split("\\.");
            int zhenshu = Integer.valueOf(nums[0]);
            if (nums[1].charAt(0) <= '4'){
                System.out.println(zhenshu);
            } else {
                System.out.println(zhenshu + 1);
            }
        }
    }
}
