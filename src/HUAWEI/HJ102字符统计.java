package HUAWEI;

import java.util.*;

public class HJ102字符统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            int[] num =  new int[10+26];
            for (int i = 0 ; i < str.length(); ++i){
                if (str.charAt(i) <= 'z' && 'a' <= str.charAt(i)){
                    num[str.charAt(i) - 'a' + 10] += 1;
                } else {
                    num[str.charAt(i) - '0'] += 1;
                }
            }
            List<Item> list = new LinkedList<Item>();
            for (int i = 0; i < num.length; ++i){
                if (num[i] != 0){
                    if (i <= 9){
                        list.add(new Item((char) ('0' + i), num[i]));
                    } else {
                        list.add(new Item((char) ('a' + i - 10), num[i]));
                    }
                }
            }
            Collections.sort(list, new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    if (o1.time > o2.time){
                        return 1;
                    } else if (o1.time < o2.time){
                        return -1;
                    } else {
                        if (o1.ch > o2.ch){
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                }
            });
            String res = "";
            for (int i = list.size() - 1; i >= 0; i--){
                res += list.get(i).ch;
            }
            System.out.println(res);
        }
    }

    static class Item{
        char ch;
        int time;
        Item(char ch, int time){
            this.ch = ch;
            this.time = time;
        }
    }
}
