package HUAWEI;

import java.util.*;

public class HJ66配置文件恢复 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String[] commands = scanner.nextLine().split(" ");
            Map<String, String> map = new HashMap<String, String>();
            map.put("reset", "reset what");
            map.put("reset board", "board fault");
            map.put("board add", "where to add");
            map.put("board delete", "no board at all");
            map.put("reboot backplane", "impossible");
            map.put("backplane abort", "install first");
            List<String> list = new ArrayList<>();
            list.add("reset board");
            list.add("board add");
            list.add("board delete");
            list.add("reboot backplane");
            list.add("backplane abort");
            if (commands.length == 1){
                if ("reset".startsWith(commands[0])){
                    System.out.println(map.get("reset"));
                } else {
                    System.out.println("unknown command");
                }
            } else {
                List<String> matched = new LinkedList<>();
                for (int i = 0; i < list.size(); ++i){
                    String[] whole_command = list.get(i).split(" ");
                    if (whole_command[0].startsWith(commands[0]) && whole_command[1].startsWith(commands[1])){
                        matched.add(list.get(i));
                    }
                }
                if (matched.size() != 1){
                    System.out.println("unknown command");
                } else {
                    System.out.println(map.get(matched.get(0)));
                }
            }
        }
    }
}
