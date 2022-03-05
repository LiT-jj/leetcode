import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 微软笔试 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3298));
    }
}
class Solution1  {
    public String solution(String S, String T) {
        // write your code in Java SE 8
        if (S.equals(T)){
            return "IMPOSSIBLE";
        }
        if (S.length() - T.length() == 0){
            int n = 0;
            for (int i = 0; i < S.length(); ++i){
                if (S.charAt(i) != T.charAt(i)){
                    n++;
                }
            }
            if (n == 1){
                return change(S, T);
            } else if (n == 2){
                return swap(S, T);
            } else {
                return "IMPOSSIBLE";
            }
        } else if (T.length() - S.length() == 1){
            String new_s = T.charAt(0) + S;
            if (new_s.equals(T)){
                return String.format("INSERT %c", T.charAt(0));
            } else {
                return "IMPOSSIBLE";
            }
        } else {
            return "IMPOSSIBLE";
        }
    }

    public String swap(String s, String t) {
        int[] index = new int[2];
        int j = 0;
        for (int i = 0; i < s.length(); ++i){
            if (s.charAt(i) != t.charAt(i)){
                index[j++] = i;
            }
        }
        return String.format("SWAP %c %c", s.charAt(index[0]), s.charAt(index[1]));
    }

    public String change(String s, String t) {
        for (int i = 0; i < s.length(); ++i){
            if (s.charAt(i) != t.charAt(i)){
                return String.format("CHANGE %c %c", s.charAt(i), t.charAt(i));
            }
        }
        return "IMPOSSIBLE";
    }


}

class Solution2 {
    public int solution(String A, String B) {
        // write your code in Java SE 8
        int[] timeA = new int[2];
        int[] timeB = new int[2];
        String[] StringA = A.split(":");
        String[] StringB = B.split(":");

        timeA[0] = Integer.valueOf(StringA[0]);
        timeA[1] = Integer.valueOf(StringA[1]);
        timeB[0] = Integer.valueOf(StringB[0]);
        timeB[1] = Integer.valueOf(StringB[1]);

        if (timeB[0] < timeA[0] || (timeB[0] == timeA[0] && timeA[1] > timeB[1] )){
            int res = (24 - 1 - timeA[0] + timeB[0]) * 4 + (60 - timeA[1]) / 15 + timeB[1] / 15;
            return  res;
        } else if (timeB[0] == timeA[0]){
            if (timeA[1] == timeB[1]){
                return 0;
            }
            int res  = (functionB(timeB[1]) - functionA(timeA[1])) / 15;
            return res;
        } else {
            int res = 4 * (timeB[0] - timeA[0] - 1);
            res += timeB[1] / 15;
            res += (60 - timeA[1]) / 15;
            return res;
        }
    }
    public int functionA(int i){
        if (0 < i && i < 15){
            return 15;
        } else if (15 < i && i < 30){
            return 30;
        } else if (30 < i && i < 45){
            return 45;
        } else if (45 < i && i < 60) {
            return 60;
        } else {
            return i;
        }
    }

    public int functionB(int i){
        if (0 < i && i < 15){
            return 0;
        } else if (15 < i && i < 30){
            return 15;
        } else if (30 < i && i < 45){
            return 30;
        } else if (45 < i && i < 60) {
            return 45;
        } else {
            return i;
        }
    }
}

class Solution {
    public int solution(int N) {
        int res = N + 1;
        while (!function(res)){
            res ++;
        }
        return res;
    }
    public boolean function(int n){
        String string_n = String.valueOf(n);
        for (int i = string_n.length() - 1; i >= 1; --i){
            if (string_n.charAt(i) == string_n.charAt(i - 1)){
                return false;
            }
        }
        return true;
    }
}
