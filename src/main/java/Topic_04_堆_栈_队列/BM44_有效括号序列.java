package Topic_04_堆_栈_队列;

import java.util.Stack;

public class BM44_有效括号序列 {
    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            switch (ch){
                case('('):
                case('['):
                case('{'):
                    stack.push(ch);
                    break;
                case(')'):
                    if(stack.isEmpty()){
                        return false;
                    }
                    char ch1 = stack.pop();
                    if (ch1 != '('){
                        return false;
                    }
                    break;
                case(']'):
                    if(stack.isEmpty()){
                        return false;
                    }
                    char ch2 = stack.pop();
                    if (ch2 != '['){
                        return false;
                    }
                    break;
                case('}'):
                    if(stack.isEmpty()){
                        return false;
                    }
                    char ch3 = stack.pop();
                    if (ch3 != '{'){
                        return false;
                    }
                    break;
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
