package HUAWEI;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HJ44Sudoku {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] pannel = new int[9][9];
        for (int i = 0 ; i < pannel.length; ++i){
            for (int j = 0; j < pannel[i].length; ++j){
                pannel[i][j] = scanner.nextInt();
            }
        }
        List<Pos> list = justify(pannel);
        while(list.size() > 0){
            int last_size = list.size();
            for (int i = 0; i < list.size(); ++i){
                Pos pos = list.get(i);
                if (write(pannel, pos)){
                    list.remove(pos);
                }
            }
            int current_size = list.size();
            if (current_size == last_size){
                break;
            }
        }
        function(pannel, list);
        for (int i = 0; i < pannel.length; ++i){
            String res = "";
            for (int j = 0; j < pannel[i].length; ++j){
                res  = res + " " + pannel[i][j];
            }
            System.out.println(res.trim());
        }
    }

    private static void function(int[][] pannel, List<Pos> list) {
        if (list.size() == 0){
            return;
        }
        //回溯法将剩余的数字填完

    }

    private static boolean write(int[][] pannel, Pos pos) {
        LinkedList<Integer> listx = new LinkedList<>();
        LinkedList<Integer> listy = new LinkedList<>();
        LinkedList<Integer> listz = new LinkedList<>();

        int[] flag = new int[10];
        for (int i = 0; i < 9; ++i){
            flag[pannel[pos.x][i]] = 1;
        }
        for (int i = 0 ; i < 10; ++i){
            if (flag[i] == 0){
                listx.add(i);
            }
        }

        flag = new int[10];
        for (int i = 0; i < 9; ++i){
            flag[pannel[i][pos.y]] = 1;
        }
        for (int i = 0; i < 10; ++i){
            if (flag[i] == 0){
                listy.add(i);
            }
        }

        flag = new int[10];
        int x = pos.x / 3;
        int y = pos.y / 3;
        for (int i = 3 * x; i < 3 * (x + 1); ++i){
            for (int j = 3 * y; j < 3 * (y + 1); ++j){
                flag[pannel[i][j]] = 1;
            }
        }
        for (int i = 0; i < 10; ++i){
            if (flag[i] == 0){
                listz.add(i);
            }
        }
        List<Integer> posible = new LinkedList<>();
        for (int i = 0; i < listx.size(); i++) {
            int num = listx.get(i);
            if (listy.contains(num) && listz.contains(num)){
                posible.add(num);
            }
        }
        if (posible.size() == 1){
            pannel[pos.x][pos.y] = posible.get(0);
            return true;
        } else {
            return false;
        }
    }

    public static List<Pos> justify(int[][] pannel){
        LinkedList<Pos> list = new LinkedList<>();
        for (int i = 0; i < pannel.length; ++i){
            for (int j = 0; j < pannel[i].length; ++j){
                if (pannel[i][j] == 0){
                    list.add(new Pos(i, j));
                }
            }
        }
        return list;
    }
    static class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
