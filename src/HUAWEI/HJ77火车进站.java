package HUAWEI;

import java.util.Scanner;
import java.util.Stack;

public class HJ77火车进站 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i){
                nums[i] = i + 1;
            }
        }
    }

    static class MyStack{
            int[] train;
            Stack<Integer> stack;
            MyStack(){

            }
    }
}
