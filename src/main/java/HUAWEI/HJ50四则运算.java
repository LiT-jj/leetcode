package HUAWEI;
import java.util.Scanner;
import java.util.Stack;

public class HJ50四则运算 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            str = str.replace("{", "(")
                    .replace("}",")")
                    .replace("[","(")
                    .replace("]",")")
                    .replace("(-","(0-");
            if (str.startsWith("-")){
                str = "0" + str;
            }
            int res = function(str);
            System.out.println(res);
        }
    }

    private static int function(String str) {
        Stack<Integer> int_stack = new Stack<>();
        Stack<Character> opt_stack = new Stack<>();
        int i = 0;
        while(i < str.length()){
            char ch = str.charAt(i);
            if (ch == '('){
                opt_stack.push(ch);
                i++;
            } else if (Character.isDigit(ch)){
                int j = i + 1;
                while(j < str.length() && Character.isDigit(str.charAt(j))){
                    j++;
                }
                int_stack.push(Integer.valueOf(str.substring(i, j)));
                i = j;
            } else if (ch == ')'){
                char opt = opt_stack.pop();
                while(opt != '('){
                    int num2 = int_stack.pop();
                    int num1 = int_stack.pop();
                    int_stack.push(computer(num1, num2, opt));
                    opt = opt_stack.pop();
                }
                i++;
            } else {
                //ch 为 + - * /
                if (!opt_stack.isEmpty() && getPriority(ch) <= getPriority(opt_stack.peek())){
                    while(!opt_stack.isEmpty() && getPriority(ch) <= getPriority(opt_stack.peek())){
                        char opt = opt_stack.pop();
                        int num2 = int_stack.pop();
                        int num1 = int_stack.pop();
                        int_stack.push(computer(num1, num2, opt));
                    }
                }
                opt_stack.push(ch);
                i++;
            }
        }
        while(!opt_stack.isEmpty()){
            char opt = opt_stack.pop();
            int num2 = int_stack.pop();
            int num1 = int_stack.pop();
            int_stack.push(computer(num1, num2, opt));
        }
        return int_stack.pop();
    }

    private static int getPriority(char opt){
        switch (opt){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
    private static int computer(int num1, int num2, char opt) {
        switch (opt){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return -1;
    }
}
