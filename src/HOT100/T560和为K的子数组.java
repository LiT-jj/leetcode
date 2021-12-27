package HOT100;

public class T560和为K的子数组 {
    public static void main(String[] args) {
        int a[] = new int[]{28, 54, 7, -70, 22, 65, -6};
        System.out.println(subarraySum(a, 100));
    }
    public static int subarraySum(int[] nums, int k) {
        int num = 0;
        for(int i = 0; i < nums.length; ++i){
            int sum = nums[i];
            if(sum == k){
                num ++;
            }
            for(int j = i + 1; j < nums.length; ++j){
                sum += nums[j];
                    if(sum == k){
                        num++;
                    }

            }
        }
        return num;
    }
}
