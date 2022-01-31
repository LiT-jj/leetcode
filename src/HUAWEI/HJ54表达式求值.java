package HUAWEI;

import java.util.Scanner;
import java.util.Stack;

public class HJ54表达式求值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            if (str.startsWith("-")){
                str = "0"+str;
            }
            str = str.replace("(-", "(0-");
            System.out.println(function(str));
        }
    }
    public static int function(String formula){
        Stack<Character> char_stack = new Stack<>();
        Stack<Integer> int_stack = new Stack<>();
        int i = 0;
        int res = 0;
        while(i < formula.length()){
            char ch = formula.charAt(i);
            if (ch == '('){
                char_stack.push(formula.charAt(i));
                i++;
            } else if ('0' <= ch && ch <= '9'){
                int j = i + 1;
                while(j < formula.length() && ('0' <= formula.charAt(j) && formula.charAt(j) <= '9')){
                    j++;
                }
                int_stack.push(Integer.valueOf(formula.substring(i, j)));
                i = j;
            } else if (isOperation(ch)){
                if (char_stack.isEmpty()){
                    char_stack.push(ch);
                } else {
                    if (char_stack.peek() == '('){
                        char_stack.push(ch);
                    } else {
                        if (getPriority(ch) > getPriority(char_stack.peek())){
                            char_stack.push(ch);
                        } else {
                            while(char_stack.isEmpty() == false && getPriority(ch) <= getPriority(char_stack.peek())){
                                int num2 = int_stack.pop();
                                int num1 = int_stack.pop();
                                char operation = char_stack.pop();
                                int num = compute(num1, num2, operation);
                                int_stack.push(num);
                            }
                            char_stack.push(ch);
                        }
                    }
                }
                i++;
            } else {
                // ch == ')'
                char operation_ch = char_stack.pop();
                while(operation_ch != '('){
                    int num2 = int_stack.pop();
                    int num1 = int_stack.pop();
                    int num = compute(num1, num2, operation_ch);
                    int_stack.push(num);
                    operation_ch = char_stack.pop();
                }
                i++;
            }
        }
        while(char_stack.isEmpty() == false){
            int num2 = int_stack.pop();
            int num1 = int_stack.pop();
            char operation = char_stack.pop();
            res = compute(num1, num2, operation);
            int_stack.push(res);
        }
        return int_stack.pop();
    }

    private static int compute(int num1, int num2, char operation) {
        switch (operation){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return -1;
        }
    }

    public static boolean isOperation(char ch){
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            return true;
        }
        return false;
    }
    public static int getPriority(char ch){
        switch (ch){
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            default:
                return -1;
        }
    }
}
