package HUAWEI;

import java.util.Scanner;

public class HJ83二维数组操作 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            TwoDimensionArray twoDimensionArray = new TwoDimensionArray();
            //1.初始化数据表
            String[] row_col = scanner.nextLine().split(" ");
            int row = Integer.valueOf(row_col[0]);
            int col = Integer.valueOf(row_col[1]);
            System.out.println(twoDimensionArray.init(row, col));
            //2.交换两点值
            String[] swap_point = scanner.nextLine().split(" ");
            int x1 = Integer.valueOf(swap_point[0]);
            int y1 = Integer.valueOf(swap_point[1]);
            int x2 = Integer.valueOf(swap_point[2]);
            int y2 = Integer.valueOf(swap_point[3]);
            System.out.println(twoDimensionArray.swap(x1, y1, x2, y2));
            //3.在x行上方添加一行
            int x = Integer.valueOf(scanner.nextLine());
            System.out.println(twoDimensionArray.insertRow(x));
            //4.在y列左边添加一列
            int y = Integer.valueOf(scanner.nextLine());
            System.out.println(twoDimensionArray.insertCol(y));
            //5.查询第x行y列的值
            String[] inquire_row_col = scanner.nextLine().split(" ");
            int inquire_row = Integer.valueOf(inquire_row_col[0]);
            int inquire_col = Integer.valueOf(inquire_row_col[1]);
            System.out.println(twoDimensionArray.inquire(inquire_row, inquire_col));
        }
    }
    static class TwoDimensionArray{
        int[][] twoDimensionArray = new int[9][9];
        int[] row = new int[9];
        int[] col = new int[9];
        int row_len = 0;
        int col_len = 0;

        public int init(int row, int col){
            if (row <= 9 && col <= 9){
                this.row_len = row;
                this.col_len = col;
                return 0;
            } else {
                return -1;
            }
        }

        public int swap(int x1, int y1, int x2, int y2){
            if (x1 < this.row_len && x2 < this.row_len && y1 < this.col_len && y2 < this.col_len){
                return 0;
            } else {
                return -1;
            }
        }

        public int insertRow(int row){
            if (row >= this.row_len || this.row_len == 9){
                return -1;
            }
            return 0;
        }

        public int insertCol(int col){
            if (col >= this.col_len || this.col_len == 9){
                return -1;
            }
            return 0;
        }

        public int inquire(int row, int col){
            if (row < this.row_len && col < this.col_len){
                return 0;
            } else {
                return -1;
            }
        }
    }
}
