package HOT100;

public class T240搜索二维矩阵2 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix, 5));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; ++i){
            int left = 0, right = matrix[i].length  -1;
            while(left <= right){
                int mid = (left + right) >> 1;
                if(matrix[i][mid] == target){
                    return true;
                } else if(matrix[i][mid] > target){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
