package 面试题;

import java.util.*;

public class 美团测试开发 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Float[] floats = new Float[25];
        for (int i = 0; i < 25; ++i){
            floats[i] = scanner.nextFloat();
        }
        Arrays.sort(floats);
        String res = "";
        for (int i = 0; i < 5; ++i){
            float num = floats[floats.length - 1 - i];
            res += " " + function(num);
        }
        System.out.println(res.trim());
    }
    static String function(float num){
        String str_num = String.valueOf(num);
        String[] nums = str_num.split("\\.");
        int n = Integer.valueOf(nums[1]);
        if (n == 0){
            return nums[0];
        }
        return str_num;
    }

    public static class Test1 {
        static int num = 0;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] matrix = new int[m][n];

            for (int i = 0; i < m; ++i){
                for (int j = 0; j < n; ++j){
                    matrix[i][j] = scanner.nextInt();
                }
            }
            for (int i= 0; i < matrix.length; ++i){
                for (int j = 0; j < matrix[i].length; ++j){
                    if (matrix[i][j] == 1){
                        num++;
                        function(matrix, i, j);
                    }

                }
            }
            System.out.println(num);
        }

        private static void function(int[][] matrix, int row, int col) {
            //行列不符合要求
            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length){
                return;
            }
            //是陆地
            if (matrix[row][col] == 0){
                return;
            }
            //是水池
            matrix[row][col] = 0;
            function(matrix, row - 1, col);
            function(matrix, row + 1, col);
            function(matrix, row, col + 1);
            function(matrix, row, col - 1);

        }
    }

    public static class Test2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int L = scanner.nextInt();
            int K = scanner.nextInt();
            int[] lines = new int[L];
            for (int i = 0; i < L; ++i){
                lines[i] = scanner.nextInt();
            }

            //获取没有删除行，已提交行的总和
            int maxLine = 0;
            for (int i = 0; i < L; ++i){
                if (lines[i] > 0){
                    maxLine += lines[i];
                }
            }
            int Max = maxLine / K + 1;
            int Min = 1;

            List<Integer> list = new LinkedList<>();
            for (int N = Min; N <= Max; ++N){
                int currentLine = 0;
                int pass = 0;
                for (int i = 0; i < L; ++i){
                    //如果当前代码行数超过N就提交通过且currentLine置为0
                    currentLine += lines[i];
                    if (currentLine < 0){
                        currentLine = 0;
                    }
                    if (currentLine >= N){
                        pass ++;
                        currentLine = 0;
                    }
                    //运行通过数大于K，中断
                    if (pass > K){
                        break;
                    }
                }
                if (pass == K){
                    list.add(N);
                }
            }

            Collections.sort(list);
            System.out.println(String.format("%d %d", list.get(0), list.get(list.size() - 1)));



        }
    }
}
