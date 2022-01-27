package HUAWEI;

import java.util.*;

public class HJ59找出字符串中第一个只出现一次的字符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < str.length(); ++i){
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            }
            int pre = str.length() - 1;
            List<Character>list = new LinkedList<Character>();
            map.forEach((k, v) -> {
                if (v == 1) {
                    list.add(k);
                }
            });
            if (list.size() > 0){
                for (int i = 0; i < list.size(); ++i){
                    int index = str.indexOf(list.get(i));
                    if (index < pre){
                        pre = index;
                    }
                }
                System.out.println(str.charAt(pre));
            } else {
                System.out.println(-1);
            }

        }
    }
}
