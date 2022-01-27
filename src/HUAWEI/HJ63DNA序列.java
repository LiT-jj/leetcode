package HUAWEI;

import java.util.Scanner;

public class HJ63DNA序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String seq = scanner.nextLine();
            int len = Integer.valueOf(scanner.nextLine());
            String gc_seq = "";
            double gc_ration = 0.0;
            for (int i = 0 ; i < seq.length() - len + 1; ++i){
                String temp_seq = seq.substring(i, i + len);
                double ration_temp = function(temp_seq);
                if (ration_temp > gc_ration){
                    gc_seq = temp_seq;
                    gc_ration = ration_temp;
                }
            }
            System.out.println(gc_seq);
        }
    }

    private static double function(String temp_seq) {
        double num_c_g = 0;
        for(int i = 0; i < temp_seq.length(); ++i){
            if (temp_seq.charAt(i) == 'C' || temp_seq.charAt(i) == 'G'){
                num_c_g ++;
            }
        }
        return num_c_g / temp_seq.length();
    }

}
