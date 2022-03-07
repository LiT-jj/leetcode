package HOT100;

public class T647会文子串 {
    public static int countSubstrings(String s) {
        int num =0;
        for(int i = 0; i < s.length(); ++i){
            for(int j = i + 1; j < s.length() + 1; ++j){
                if(method(s.substring(i, j))){
                    num++;
                }
            }
        }
        return num;
    }

    public static boolean method(String s){
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length / 2; ++i){
            if(charArr[i] != charArr[charArr.length - 1 - i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
//        System.out.println("abc".substring(0, 1));
    }
}
