package HUAWEI;

import java.util.Scanner;

public class HJ69矩阵乘法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int[][] matrix1 = new int[x][y];
            int[][] matrix2 = new int[y][z];
            for(int i = 0; i < x; ++ i){
                for(int j = 0; j < y; ++j){
                    matrix1[i][j] = scanner.nextInt();
                }
            }
            for(int i = 0; i < y; ++i){
                for(int j = 0; j < z; ++j){
                    matrix2[i][j] = scanner.nextInt();
                }
            }
            int[][] res = new int[x][z];
            for(int i = 0; i < x; ++i){
                for(int j = 0; j < z; ++j){
                    for(int k = 0; k < y; ++k){
                        res[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            for (int i = 0; i < res.length; ++i){
                String temp_line = "";
                for (int j = 0; j < res[i].length; ++j){
                    temp_line = temp_line + " " + res[i][j];
                 }
                System.out.println(temp_line.trim());
            }

        }
    }
}
