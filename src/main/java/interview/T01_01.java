package interview;

import java.util.HashMap;

public class T01_01 {
    public static boolean isUnique(String astr){
        char[] chars = astr.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for(int i = 0; i < chars.length; ++i){
            if(hashMap.containsKey(chars[i]))
                return false;
            else {
                hashMap.put(chars[i], i);
            }
        }
        return true;
    }

    public static boolean isUnique_start(String astr){
        char[] chars = astr.toCharArray();
        int temp = 0;
        for(int i = 0; i < chars.length; ++i){
            int offset = chars[i] - 'a';
            if((temp & (1 << offset)) != 0)
                return false;
            else
                temp = temp | (1 << offset);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isUnique_start("bb"));
    }
}
