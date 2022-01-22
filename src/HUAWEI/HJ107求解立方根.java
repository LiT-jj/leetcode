package HUAWEI;

import java.math.BigDecimal;
import java.util.Scanner;

public class HJ107求解立方根 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double num = scanner.nextDouble();
        Double left = 0.0, right = 0.0;
        if (Math.abs(num) > 1){
            if (num > 0){
                left = 0.0; right = num;
            } else if (num < 0){
                left = num; right = 0.0;
            }
        } else {
            if (num > 0){
                left = num; right = 1.0;
            } else if (num < 0){
                left = -1.0; right = num;
            }
        }


        Double mid  = (left + right) / 2;
        Double lifang  = new BigDecimal(Math.pow(mid, 3)).setScale(1, BigDecimal.ROUND_HALF_DOWN).doubleValue();


        while(!lifang.equals(num) ){
            if (lifang > num){
                right = mid;
            } else {
                left = mid;
            }
            mid = (left + right) / 2;
            lifang = new BigDecimal(Math.pow(mid, 3)).setScale(3, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        }
        System.out.println(new BigDecimal(mid).setScale(1, BigDecimal.ROUND_HALF_DOWN).doubleValue());
    }
}
