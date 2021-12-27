package interview;

import java.util.LinkedList;
import java.util.Stack;

public class T03_05 {
    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }

    static class SortedStack {

        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public SortedStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int val) {
            while(s1.size() > 0 && s1.peek() < val){
                s2.push(s1.pop());
            }
            s1.push(val);
            while(s2.size() > 0){
                s1.push(s2.pop());
            }
        }

        public void pop() {
            if(s1.size() > 0)
                s1.pop();
        }

        public int peek() {
            if (s1.size() == 0){
                return -1;
            }
            return s1.peek();
        }

        public boolean isEmpty() {
            return s1.isEmpty();
        }
    }
}


