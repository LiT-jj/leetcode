package interview;

public class T05_07 {
    public static int exchangeBits(int num){
        return  ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        System.out.println(exchangeBits(3));
    }
}
