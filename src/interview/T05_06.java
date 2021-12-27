package interview;

public class T05_06 {
    public static int convertInteger(int A, int B) {
        return Integer.bitCount(A^B);
    }

    public static int getLen(int M, int N){
        int len = 0;
        while(M != 0 || N!=0){
            M = M / 2;
            N = N / 2;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = -729934991;
        System.out.println(convertInteger(a,
                b));
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));

        System.out.println(Integer.toBinaryString(a^b));
    }
}
