package HUAWEI;

import java.util.Scanner;

public class HJ38求小球落地5次后所经历的路程和第5次反弹的高度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        Item res = function(height, 0, 0);
        System.out.println(res.weiyi - height);
        System.out.println(res.height);
    }

    private static Item function(double height, double weiyi, int index) {
        weiyi = height * 2 + weiyi;
        height = height / 2.0;
        index += 1;
        if (index == 5){
            return new Item(height, weiyi);
        }
        return function(height, weiyi, index);

    }

    static class Item{
        double height;
        double weiyi;
        Item(double height, double weiyi){
            this.height = height;
            this.weiyi = weiyi;
        }
    }
}
