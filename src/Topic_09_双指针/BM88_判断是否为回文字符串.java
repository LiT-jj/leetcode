package Topic_09_双指针;

public class BM88_判断是否为回文字符串 {
    public boolean judge (String str) {
        // write code here
        int r = 0, l = str.length() - 1;
        while(r < l){
            if (str.charAt(r) != str.charAt(l)){
                return false;
            }
            r++;
            l--;
        }
        return true;
    }
}
