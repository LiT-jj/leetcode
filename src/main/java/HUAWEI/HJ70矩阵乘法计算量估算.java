package HUAWEI;

import java.util.Scanner;
import java.util.Stack;

public class HJ70矩阵乘法计算量估算 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; ++i){
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            String formula = scanner.next();
            Stack<Item> stack = new Stack<Item>();
            int num = 0;
            for (int i = 0; i < formula.length(); ++i){
                  char ch = formula.charAt(i);
                  if (ch == '('){
                      stack.push(new Item(ch));
                  } else if ('A' <= ch && ch <= 'Z'){
                      stack.push(new Item(arr[ch - 'A'][0], arr[ch - 'A'][1]));
                  } else{
                      //ch为‘）’
                      Item item1 = stack.pop();
                      Item item2 = stack.pop();
                      int row, col;
                      if (item1.row == item2.col){
                          num += item1.row * item1.col * item2.row;
                          row = item2.row;
                          col = item1.col;
                      } else {
                          //item1.col == item2.row
                          num += item1.row * item1.col + item2.col;
                          row = item1.row;
                          col = item2.col;
                      }
                      stack.pop();
                      stack.push(new Item(row, col));
                  }
            }
            System.out.println(num);
        }
    }

    static class Item{
        char ch;
        int row;
        int col;
        Item(char ch){
            this.ch = ch;
        }
        Item(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
