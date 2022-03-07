package Topic_08_字符串;

public class BM84_最长公共前缀 {
    public String longestCommonPrefix (String[] strs) {
        // write code here
        String substr = strs[0];
        while(!function(strs, substr)){
            substr = strs[0].substring(0, substr.length() - 1);
        }
        return substr;
    }

    public boolean function(String[] str, String substring){
        for (int i = 0; i < str.length; ++i){
            if (!str[i].startsWith(substring)){
                return false;
            }
        }
        return true;
    }
}
