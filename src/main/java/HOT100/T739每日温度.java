package HOT100;

import java.util.Stack;

public class T739每日温度 {

    public static int[] method_1(int[] temperatures){
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; ++i){
            for(int j = i + 1; j < temperatures.length; ++j){
                if(temperatures[j] > temperatures[i]){
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static int[] method_2(int[] T){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i = 0; i < T.length; ++i){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] temperature = new int[]{73,74,75,71,69,72,76,73};
        int[] res = method_2(temperature);
        for (int i = 0; i < res.length; ++i){
            System.out.print(res[i] + " ");
        }
    }

}
