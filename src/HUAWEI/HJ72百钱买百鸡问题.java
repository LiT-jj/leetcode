package HUAWEI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ72百钱买百鸡问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int money = scanner.nextInt() * 100;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0 ; i <= (3 * money - 100) / 5; ++i){
                int x = i;
                int y  = (3 * money - 100 - x * 14) / 8;
                if ((3 * money - 100 - x * 14) % 8 == 0 && y >= 0 && 100 - x - y >= 0){
                    map.put(x, y);
                }
            }

            map.forEach((k, v) -> {
                System.out.println(String.format("%d %d %d",k, v, 100 - k - v));
            });
        }
    }
}
