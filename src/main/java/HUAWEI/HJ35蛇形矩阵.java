package HUAWEI;

import java.util.Scanner;

public class HJ35蛇形矩阵 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0 ; i < matrix.length; ++i){
                for (int j = 0; j < matrix[i].length - i; ++j){
                    int first_num = (i + 1) * (0 + i) / 2 + 1;
                    matrix[i][j] = j * (2 * i + 3 + j) / 2 + first_num;
                }
            }
            for (int i = 0 ; i < matrix.length; ++i){
                String line_res = "";
                for (int j = 0; j < matrix[i].length - i; ++j){
                    line_res += matrix[i][j] + " ";
                }
                System.out.println(line_res.trim());
            }
        }
    }
}
