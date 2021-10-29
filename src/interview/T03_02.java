package interview;

import java.util.List;
import java.util.Stack;

class MinStack{
    private Stack<item> stack;
    static class item{
        int val;
        int minval;

        public item(int val, int minval) {
            this.val = val;
            this.minval = minval;
        }
    }

    public MinStack(){
        this.stack = new Stack<item>();
    }
    void push(int x){
        if(this.stack.size() == 0){
            this.stack.push(new item(x, x));
        } else{
            int min = this.stack.peek().minval;
            min = min < x ? min : x;
            this.stack.push(new item(x, min));
        }
    }
    void pop(){
        this.stack.pop();
    }
    int top(){
        return this.stack.peek().val;
    }
    int getMin(){
        return this.stack.peek().minval;
    }
}
public class T03_02 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483645);
        minStack.push(2147483647);
        minStack.top();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        minStack.getMin();
        minStack.push(-2147483648);
        minStack.top();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }
}

