package interview;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        while(true){
            queue.add(1);
            System.out.println(queue.size());
        }
    }
}
