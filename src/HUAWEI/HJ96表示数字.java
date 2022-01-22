package HUAWEI;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HJ96表示数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            char[] charArr = str.toCharArray();
            int i = 0;
            List<Item> list = new LinkedList<Item>();
            while (i < charArr.length){
                if ('0' <= charArr[i] && charArr[i] <= '9'){
                    int j = i+1;
                    String num = "" + charArr[i];
                    while(j < charArr.length && ('0' <= charArr[j] && charArr[j] <= '9')){
                        num += charArr[j];
                        j++;
                    }
                    list.add(new Item(i, j-1));
                    i = j;
                }
                i++;
            }
            char[] res = new char[list.size()*2 + charArr.length];
            int[] left_right = new int[list.size()*2];
            i = 0;
            for (int n = 0; n < list.size();++n){
                left_right[i++] = list.get(n).left + 2*n;
                left_right[i++] = list.get(n).right+2+2*n;
            }
            i = 0;
            int n = 0;
            for (int m = 0 ; m < res.length; ++m){
                if (i >= left_right.length || m != left_right[i]){
                    res[m] = charArr[n++];
                } else {
                    res[m] = '*';
                    i++;
                }
            }
            String res_str = String.valueOf(res);
            System.out.println(res_str);
        }
    }
    static class Item{
        int left;
        int right;
        Item(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}
