package HOT100;

import java.util.*;

public class T438找到字符串中所有字母异位词 {


    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        int n = s.length(), m = p.length();
        if (m > n) {
            return res;
        }
        char[] as = s.toCharArray();
        char[] ap = p.toCharArray();
        int[] h1 = new int[26];
        int[] h2 = new int[26];

        for (char ch : ap) {
            h2[ch - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            h1[as[i] - 'a']++;
        }
        if (Arrays.equals(h1, h2)) {
            res.add(0);
        }

        for (int i = m; i < n; i++) {
            h1[as[i - m] - 'a']--;
            h1[as[i] - 'a']++;
            if (Arrays.equals(h1, h2)) {
                res.add(i - m + 1);
            }
        }

        return res;
    }
}
