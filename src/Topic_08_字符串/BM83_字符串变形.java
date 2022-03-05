package Topic_08_字符串;

import java.util.Stack;

public class BM83_字符串变形 {
    public static void main(String[] args) {
        System.out.println(trans("This is a sample", 16));
    }
    public static String trans(String s, int n) {
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); ++i){
            if (s.charAt(i) == ' '){
                stack.push(stringBuilder.toString());
                stack.push(" ");
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder.append(convert(s.charAt(i)));
            }

        }

        if (stringBuilder.length() != 0){
            stack.push(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static char convert(char ch){
        if (Character.isUpperCase(ch)){
            return Character.toLowerCase(ch);
        } else if (Character.isLowerCase(ch)){
            return Character.toUpperCase(ch);
        }
        return ch;
    }

}
