package interview;

public class T05_04 {
    public static int[] findClosedNumbers(int num) {
        if (num == 1) return new int[]{2, -1};
        if (num == 2147483647) return new int[]{-1,-1};
        int index = -1;
        int preIndex = -1;
        //找1,1的位置为0
        for (int i = 0 ; i < 32; ++i){
           if ((num & (1 << i)) != 0){
               index = i;
               break;
           }
        }
        //找index左边第一个出现0的位置
        for(int i = index + 1; i < 32; ++i){
            if ((num & (1 << i)) == 0){
                preIndex = i;
                break;
            }
        }
        int[] res = new int[]{-1, -1};
        res[0] = num - (1 << preIndex - 1) + (1 << preIndex);

        for (int i = 0; i < 32; ++i){
           if ((num & (2 << i)) == 2 && (num & (1 << i)) == 0){
                index = i;
                break;
           }
        }
//        res[1] = num >> (index + 1) << (index + 1);
//        int numOf1 = Integer.valueOf(num1 ^ num);
//        for (int i = 0; i < numOf1; ++i){
//            num1 += 1 << (index - i);
//        }
//        res[1] = num1;
        return res;
    }

    public static void main(String[] args) {
        int a = 195;
        int[] res = findClosedNumbers(a);
        System.out.println(String.valueOf(res[0]) + ", " + String.valueOf(res[1]));
    }
}
