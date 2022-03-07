package interview;

public class T03_01 {
    public static void main(String[] args) {
        TripleInOne stack = new TripleInOne(1);
        stack.push(0, 1);
        stack.push(0, 2);
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.isEmpty(0));

    }

    static class TripleInOne{
        private int[] stack;
        private int[] top;
        private int stackSize;
        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            stack = new int[stackSize * 3];
            top = new int[]{-1, -1, -1};
        }

        public void push(int stackNum, int value) {
            if (top[stackNum] >= this.stackSize){
                return ;
            }
            if (top[stackNum] < this.stackSize - 1){
                top[stackNum] = top[stackNum] + 1;
                stack[stackNum * stackSize + top[stackNum]] = value;
            }
        }

        public int pop(int stackNum) {
            if (top[stackNum] < 0){
                return -1;
            }
            int num = stack[stackNum * stackSize + top[stackNum]];
            top[stackNum] = top[stackNum] - 1;
            return num;
        }

        public int peek(int stackNum) {
            if (top[stackNum] < 0)
                return -1;
            return stack[stackNum * stackSize+ top[stackNum]];
        }

        public boolean isEmpty(int stackNum) {
            if (top[stackNum] == -1)
                return true;
            return false;
        }

    }

}
