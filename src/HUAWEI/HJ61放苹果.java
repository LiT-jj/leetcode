package HUAWEI;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ61放苹果 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num_apple = scanner.nextInt();
            int num_plate = scanner.nextInt();
            int[] plate = new int[num_plate];
            Set<Integer> set = new HashSet<>();
            function(plate, 0, num_apple, set);
            System.out.println(set.size());
        }
    }

    private static void function(int[] plate, int plate_no, int remaining_appple, Set<Integer> set) {
        if (plate_no >= plate.length){
            int res = 0;
            for (int i = 0; i < plate.length; ++i){
                res += Math.pow(plate[i], 4);
            }
            set.add(res);
            return;
        }
        if (remaining_appple == 0){
            function(plate, plate_no + 1, remaining_appple, set);
        } else if (plate_no == plate.length - 1){
            plate[plate_no] = remaining_appple;
            function(plate, plate_no + 1, 0, set);
            plate[plate_no] = 0;
        } else {
            for (int i = 0; i <= remaining_appple; ++i){
                plate[plate_no] = i;
                function(plate, plate_no + 1, remaining_appple - i, set);
                plate[plate_no] = 0;
            }
        }

    }
}
