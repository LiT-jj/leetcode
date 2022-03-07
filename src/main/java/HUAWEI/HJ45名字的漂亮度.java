package HUAWEI;

import java.util.*;

public class HJ45名字的漂亮度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String num = scanner.nextLine();
            int n = Integer.valueOf(num);
            for (int i = 0 ; i < n; ++i){
                String name = scanner.nextLine();
                System.out.println(function(name));
            }
        }
    }

    private static int function(String name) {
        name = name.toLowerCase(Locale.ROOT);
        int[] arr = new int[26];
        for (int i = 0; i < name.length(); ++i){
            arr[name.charAt(i) - 'a'] ++;
        }
        for (int i = 0 ; i < arr.length - 1; ++i){
            for (int j = 0; j < arr.length - 1 - i; ++j){
                if (arr[j] < arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        int i = 0;
        int score = 0;
        while(i < arr.length && arr[i] != 0){
            score += (26 - i) * arr[i];
            i++;
        }
        return score;
    }
}
