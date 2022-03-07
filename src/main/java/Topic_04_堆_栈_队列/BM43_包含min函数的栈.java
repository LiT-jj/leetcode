package Topic_04_堆_栈_队列;

import java.util.Stack;

/**
 * 思路：https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=295&tqId=23268&ru=/practice/0bf071c135e64ee2a027783b80bf781d&qru=/ta/format-top101/question-ranking
 *
 */
public class BM43_包含min函数的栈 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        //如果minStack不为空
        if (!minStack.isEmpty()){
            if (minStack.peek() < node){
                minStack.push(minStack.peek());
            } else {
                minStack.push(node);
            }
        } else {
           minStack.push(node);
        }
    }

    public void pop() {
        if (stack.isEmpty() || minStack.isEmpty()){
            return;
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}