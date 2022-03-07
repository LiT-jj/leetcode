package interview;

import java.util.HashMap;

public class T01_02 {
    public static boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for(int i = 0; i < c1.length; ++i){
            if(hashMap.containsKey(c1[i])){
                hashMap.put(c1[i], hashMap.get(c1[i]) + 1);
            } else{
                hashMap.put(c1[i], 1);
            }
        }
        for(int i = 0; i <c2.length; ++i){
            if (!hashMap.containsKey(c2[i]))
                return false;
            hashMap.put(c2[i], hashMap.get(c2[i]) - 1);
        }
        for(Integer value: hashMap.values())
            if(value != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(CheckPermutation("abc", "bad"));
    }
}
