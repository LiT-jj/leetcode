package interview;

public class T01_07 {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2; ++i){
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }

        for(int i = 0; i < n - 1; ++i){
            for(int j = i + 1; j < n; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
    }
}
