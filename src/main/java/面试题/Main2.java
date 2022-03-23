package 面试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int op = scanner.nextInt();
        String input = scanner.next();
        if (op == 1){
            System.out.println(encode(input));
        } else {
            System.out.println(decode(input));
        }
    }

    private static String decode(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); ++i){
            stack.push(input.charAt(i));
        }

            int n = input.length();
            char[] arr = new char[n];
            int i = 0, j = n -1;
            while(!stack.isEmpty()) {
                arr[j--] = stack.pop();
                if (!stack.isEmpty()) {
                    arr[i++] = stack.pop();
                }
            }
        return new String(arr);

    }

    private static String encode(String s) {
        List<Character>  list = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i){
            list.add(s.charAt(i));
        }
        StringBuffer bf = new StringBuffer();
        while (!list.isEmpty()){
            int idx = (int) (Math.ceil(list.size() / 2.0) - 1);
            char c = list.remove(idx);
            bf.append(c);
        }
        return bf.toString();


    }
}
