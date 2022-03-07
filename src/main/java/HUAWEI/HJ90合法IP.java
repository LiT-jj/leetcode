package HUAWEI;

import java.util.Scanner;

public class HJ90合法IP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String[] words = scanner.nextLine().split("\\.");
            String res = "YES";
            if (words.length != 4){
                res = "NO";
            } else {
                for (int i = 0; i < words.length; i++) {
                    if (!justify(words[i])){
                        res = "NO";
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }

    private static boolean justify(String word) {
        if ((word.startsWith("0") && word.length() != 1) || word.indexOf("+") != -1 || word.length() == 0){
            return false;
        }
        int num = Integer.valueOf(word);
        if (0 <= num && num <= 255){
            return true;
        } else {
            return false;
        }
    }
}
