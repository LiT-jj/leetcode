package HUAWEI;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HJ4字符串分隔 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String input_string  = in.nextLine();
            if (input_string.length() <= 8){
                System.out.println(format(input_string));
            } else {
                while(input_string.length() > 8){
                    String new_string = input_string.substring(0, 8);
                    System.out.println(format(new_string));
                    input_string = input_string.substring(8);
                }
                System.out.println(format(input_string));
            }
        }
    }

    public static String format(String str){
        if (str.length() == 0){
            return str;
        } else if(str.length() > 8) {
            return str.substring(0, 8);
        } else {
            String suffix = "";
            for (int i =0; i < 8 - str.length(); ++i){
                suffix += "0";
            }
            return str + suffix;
        }
    }
}
