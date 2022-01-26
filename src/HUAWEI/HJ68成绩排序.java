package HUAWEI;

import java.util.*;

public class HJ68成绩排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            int n = Integer.valueOf(scanner.nextLine());
            int flag = Integer.valueOf(scanner.nextLine());
            List<Item> list = new ArrayList<>();
            for (int i = 0 ; i < n; ++i){
                String[] name_score = scanner.nextLine().split(" ");
                list.add(new Item(name_score[0], Integer.valueOf(name_score[1])));
            }
            if (flag == 1){
                list.sort(new Comparator<Item>() {
                    @Override
                    public int compare(Item o1, Item o2) {
                        return o1.score - o2.score;
                    }
                });
            } else {
                list.sort(new Comparator<Item>(){
                    @Override
                    public int compare(Item o1, Item o2){
                        return o2.score - o1.score;
                    }
                });
            }
            list.forEach(item -> System.out.println(String.format("%s %d", item.name, item.score)));


        }
    }
    static class Item{
        String name;
        int score;
        Item(String name, int score){
            this.name = name;
            this.score = score;
        }
    }
}
