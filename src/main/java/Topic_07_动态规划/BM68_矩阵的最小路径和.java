package Topic_07_动态规划;

public class BM68_矩阵的最小路径和                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   {
    public int minPathSum (int[][] matrix) {
        // write code here
        for (int i = 1; i < matrix[0].length; ++i){
            matrix[0][i] = matrix[0][i-1] + matrix[0][i];
        }

        for (int i = 1; i < matrix.length; ++i){
            matrix[i][0] = matrix[i-1][0] + matrix[i][0];
        }

        for (int i = 1; i < matrix.length; ++i){
            for (int j = 1; j < matrix[i].length; ++j){
                matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i][j-1]);
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }
}
