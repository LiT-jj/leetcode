package HUAWEI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ88扑克牌大小 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            String[] card = str.split("\\-");
            String res = compare(card[0], card[1]);
            System.out.println(res);
        }
       scanner.close();
    }

    private static String compare(String card1, String card2) {
        String[] type = new String[]{"个子","对子","顺子","三个","炸弹","对王"};
        String[] boomType = new String[]{"炸弹", "对王"};
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("2", 1);
        map.put("3", 2);
        map.put("4", 3);
        map.put("5", 4);
        map.put("6", 5);
        map.put("7", 6);
        map.put("8", 7);
        map.put("9", 8);
        map.put("10", 9);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("joker", 14);
        map.put("JOKER", 15);
        String type1 = typeOf(card1);
        String type2 = typeOf(card2);
        String res = "ERROR";
        if (type1 == type2){
            String first_card1 = card1.split(" ")[0];
            String first_card2 = card2.split(" ")[0];
            res = map.get(first_card1) > map.get(first_card2) ? card1 : card2;
        } else {
            if (type1.equals("对王") || type2.equals("对王")){
                res = type1.equals("对王") ? card1 : card2;
            } else if (type1.equals("炸弹") || type2.equals("炸弹")){
                res = type1.equals("炸弹") ? card1 : card2;
            } else {
                res = "ERROR";
            }
        }
        return res;
    }

    private static String typeOf(String card) {
        String[] c = card.split(" ");
        if (c.length == 1){
            return "个子";
        } else if (c.length == 2){
            if (c[0].equals(c[1])){
                return "对子";
            } else {
                return "对王";
            }
        } else if (c.length == 3){
            return "三个";
        } else if (c.length == 4){
            return "炸弹";
        } else if (c.length == 5){
            return "顺子";
        } else {
            return "ERROR";
        }
    }

}
