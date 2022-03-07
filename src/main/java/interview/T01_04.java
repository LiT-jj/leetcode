package interview;

import java.util.HashMap;
import java.util.Map;

public class T01_04 {
    public static boolean canPermutePalindrome(String s) {
        char[] charArr = s.toCharArray();
        Map<Character, Integer> hashmap = new HashMap<Character, Integer>();
        for(int i = 0; i < charArr.length; ++i){
            if (hashmap.containsKey(charArr[i])){
                int num = (int) hashmap.get(charArr[i]);
                hashmap.put(charArr[i], num + 1);
            } else {
                hashmap.put(charArr[i], 1);
            }
        }
        int numOfOval = 0;
        for(Integer i: hashmap.values()) {
            if (i % 2 == 1)
                numOfOval++;
            if (numOfOval > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("tactcoa"));
    }
}
