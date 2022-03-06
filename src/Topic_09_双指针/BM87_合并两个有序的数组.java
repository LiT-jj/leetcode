package Topic_09_双指针;

import java.util.Arrays;

public class BM87_合并两个有序的数组 {
    public void merge(int A[], int m, int B[], int n) {
        for (int i = m; i < m + n; ++i){
            A[i] = B[i - m];
        }
        Arrays.sort(A);
    }
}
