package HUAWEI;

import java.util.Scanner;

public class HJ37统计每个月兔子的总数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] res = "1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 121393 196418 317811 514229 832040 1346269".split(" ");
        while(scanner.hasNextInt()){
            int month = scanner.nextInt();
            int[][] detail = new int[month+1][3];
            detail[1][0] = 1;
            for (int i = 2; i <= month; ++i){
                detail[i][2] = detail[i - 1][2] + detail[i - 1][1];
                detail[i][1] = detail[i - 1][0];
                detail[i][0] = detail[i][2];
            }
            System.out.println(detail[month][0] + detail[month][1] + detail[month][2]);
        }
    }
}
