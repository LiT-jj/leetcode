package Topic_07_动态规划;

public class BM73_最长回文子串 {
    public int getLongestPalindrome (String A) {
        // write code here
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length(); ++i){
            int left_offset = i - 1;
            int right_offset = i + 1;
            if (max < 1){
                max = 1;
            }
            while(0 <= left_offset && right_offset < A.length() && A.charAt(left_offset) == A.charAt(right_offset)){
                if (right_offset - left_offset + 1> max){
                    max = 1 + right_offset - left_offset;
                }
                left_offset --;
                right_offset ++;

            }
            if (i + 1 < A.length() && A.charAt(i) == A.charAt(i + 1)){
                left_offset = i - 1;
                right_offset = i + 2;
                if (max < 2){
                    max = 2;
                }
                while(0 <= left_offset && right_offset < A.length() && A.charAt(left_offset) == A.charAt(right_offset)){
                    if (right_offset - left_offset + 1 > max){
                        max = 1 + right_offset - left_offset;
                    }
                    left_offset --;
                    right_offset ++;
                }
            }
        }
        return max;
    }
}
