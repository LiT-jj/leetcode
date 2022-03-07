package HOT100;

import java.util.*;

public class T301删除无效的括号 {

    public static void main(String[] args) {
        String s = "))(((((()())(()";
        List<String> res = removeInvalidParentheses(s);
        System.out.println(res);
    }
    static Set<String> hashSet = new HashSet<String>();
    public static List<String> removeInvalidParentheses(String s) {
        int len_left = 0;
        int len_right = 0;
        for (int i = 0; i < s.length(); ++i){
            if (s.charAt(i) == '('){
                len_left ++;
            }
            if (s.charAt(i) == ')'){
                if (len_left == 0)
                    len_right ++;
                if (len_left > 0)
                    len_left --;
            }

        }
        backTrack(s, len_left, len_right);
        List<String> res = new ArrayList<String>();
        for(String item: hashSet){
            res.add(item);
        }
        return res;
    }

    private static void backTrack(String s, int len_left, int len_right) {
        if (len_left == 0 && len_right == 0){
            if (justify(s)){
                hashSet.add(s);
            }
            return;
        }
        for (int i = 0 ; i < s.length(); ++i){
            String s1 = s.substring(0, i) + s.substring(i + 1);
            if (len_left > 0 && s.charAt(i) == '('){
                backTrack(s1, len_left - 1, len_right);
            }
            if (len_right > 0 && s.charAt(i) == ')'){
                backTrack(s1, len_left, len_right - 1);
            }
        }
    }
    private static boolean justify(String s){
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i){
            if (s.charAt(i) == '('){
               stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')'){
                if (stack.isEmpty() == true){
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
