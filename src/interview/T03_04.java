package interview;

import java.util.Stack;


public class T03_04 {
    public static void main(String[] args) {

    }

    class MyQueue{
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue(){
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        public void push(int x){
            stack1.push(x);
        }
        public int pop(){
            peek();
            return stack2.pop();
        }
        public int peek(){
            if(stack2.size() > 0){
                return stack2.peek();
            }
            while(stack1.size() > 0){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
        public boolean empty(){
            return stack2.isEmpty() && stack1.isEmpty() ? true : false;
        }
    }
}
