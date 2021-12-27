package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class T01_08 {
    static class Item{
        int row;
        int col;
        Item(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void setZeroes(int[][] matrix) {
        Set<Item> set = new HashSet<>();
        for(int i = 0; i < matrix.length; ++i){
            for (int j = 0; j < matrix[i].length; ++j){
                if (matrix[i][j] == 0){
                    set.add(new Item(i, j));
                }
            }
        }
        for (Iterator<Item> it = set.iterator(); it.hasNext(); ) {
            Item item = it.next();
            int col = item.col;
            int row = item.row;
            for (int i = 0; i < matrix.length; i++){
                matrix[i][col] = 0;
            }
            for (int i = 0; i < matrix[row].length; ++i){
                matrix[row][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        Utils.printMatrix(matrix);
    }
}
