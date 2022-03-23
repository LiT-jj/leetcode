package 滑动窗口;

import java.util.HashSet;
import java.util.Set;

public class LC_3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int winR = 0, winL = 0;
        Set<Character> window = new HashSet<>();
        //记录滑动窗口的最大值
        int size = s.length() == 0 ? 0 : Integer.MIN_VALUE;
        while(winR < s.length()){
            char ch = s.charAt(winR);
            //如果窗口中没有该字符
            if(!window.contains(ch)){
                window.add(ch);
                winR ++;
                if(window.size() > size){
                    size = window.size();
                }
            } else {
                //窗口中含有该字符
                while(winL < winR && window.contains(ch)){
                    char temp = s.charAt(winL ++);
                    window.remove(temp);
                }
            }
        }
        return size;
    }
}
