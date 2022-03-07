package HUAWEI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ94记票统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String n = scanner.nextLine();
            String[] names = scanner.nextLine().split(" ");
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < names.length; ++i){
                map.put(names[i], 0);
            }
            n = scanner.nextLine();
            int invalid = 0;
            String[] ticket = scanner.nextLine().split(" ");
            for (int i = 0; i < ticket.length; ++i){
                if (map.containsKey(ticket[i])){
                    map.put(ticket[i], map.getOrDefault(ticket[i], 0) + 1);
                } else {
                    invalid++;
                }
            }
            for (int i = 0; i < names.length; i++) {
                System.out.println(String.format("%s : %d",names[i], map.get(names[i])));
            }
            System.out.println(String.format("Invalid : %d", invalid));
        }

    }
}
