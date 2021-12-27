package interview;

public class T05_01 {
    public static int insertBits(int N, int M, int i, int j) {
        int len = getLen(M, N, j);
        int res = 0, bitNum;
        for(int n = 0; n <= len; ++n){
            bitNum = (i <= n && n <= j) ? (1 << n) & (M << i) : (1 << n) & N;
            res =  res + bitNum;
        }
        return res;
    }

    public static int getLen(int M, int N, int j){
        int len = 0;
        while(M != 0 || N!=0){
            M = M / 2;
            N = N / 2;
            len++;
        }
        return len < j ? j : len;
    }

    public static void main(String[] args) {
        int res = insertBits(126194517, 2982082, 9, 30);
        System.out.println(res);
    }

}
