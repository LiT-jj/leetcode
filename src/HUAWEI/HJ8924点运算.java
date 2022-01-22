package HUAWEI;

import java.util.*;

public class HJ8924点运算 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cards = scanner.nextLine().split(" ");
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("A", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        int[] nums = new int[4];
        String res = "";
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])){
                nums[i] = map.get(cards[i]);
            } else {
                res = "ERROR";
            }
        }
        if (res.length() == 0){
            Stack<Character> opt = new Stack<Character>();
            Stack<Integer> card = new Stack<Integer>();

            int[] flag = new int[4];
            res = function(nums, opt, card, flag, 0);
        }
        System.out.println(res);

    }

    private static String function(int[] nums, Stack<Character> opt, Stack<Integer> card, int[] flag, int num) {
        if (flag[0] + flag[1] + flag[2] + flag[3] == 4 && num  == 24){
            String str = String.valueOf(card.pop()) + String.valueOf(opt.pop()) + String.valueOf(card.pop()) + String.valueOf(opt.pop()) + String.valueOf(card.pop()) + String.valueOf(opt.pop()) + String.valueOf(card.pop());
            return str;
        } else if (flag[0] + flag[1] + flag[2] + flag[3] == 4){
            return "NONE";
        }
        String res = "NONE";
        for (int i = 0; i < nums.length; i++) {

            if (flag[i] == 0) {
                card.push(nums[i]);

                flag[i] = 0;
                card.pop();
            }
        }
        return res;
    }
}
