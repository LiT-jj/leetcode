package Topic_04_堆_栈_队列;

import java.util.Stack;

public class BM42_用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        return -1;
    }
}
