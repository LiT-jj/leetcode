package interview;

public class T003 {
    public static String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        char[] temp = new char[]{'%', '2', '0'};
        int numOfSpace = 0;

        for(int i = 0; i < length; ++i){
            if(chars[i] == ' '){
                numOfSpace++;
            }
        }


        int r = length + 2 * numOfSpace - 1;
        int l = length - 1;
        while(l != r){
            if (chars[l] != ' '){
                chars[r--] = chars[l--];
            } else {
                for(int i = temp.length - 1; i >= 0; --i){
                    chars[r--] = temp[i];
                }
                l--;
            }
        }
        return String.valueOf(chars).trim();
    }
    public static void main(String[] args) {
        System.out.println(replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
    }
}
