package HOT100;

public class T461汉明距离 {
    public static int hammingDistance(int x, int y) {
        return  Integer.bitCount(x^y);
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(3, 5));
    }
}
