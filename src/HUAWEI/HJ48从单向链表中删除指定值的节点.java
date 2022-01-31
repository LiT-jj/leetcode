package HUAWEI;

import java.util.Scanner;

public class HJ48从单向链表中删除指定值的节点 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int val = scanner.nextInt();
            LinkedList head = new LinkedList(val);
            for (int  i = 0 ; i < n -1; ++i){
                val = scanner.nextInt();
                int pre = scanner.nextInt();
                insert(head, val, pre);
            }
            int num = scanner.nextInt();
            if (head.val == num){
                head = head.next;
            } else {
                LinkedList p = head;
                while(p.next!= null && p.next.val != num){
                    p = p.next;
                }
                if (p.next.val == num){
                    p.next = p.next.next;
                }
            }
            LinkedList temp = head;
            String res = "";
            while (temp != null){
                res = res + " " + temp.val;
                temp = temp.next;
            }
            System.out.println(res.trim());
        }
    }

    static class LinkedList{
        int val;
        LinkedList next;
        LinkedList(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static void insert(LinkedList head, int val, int pre){
        LinkedList p = head;
        while(p.val != pre){
            p = p.next;
        }
        LinkedList temp = new LinkedList(val);
        temp.next = p.next;
        p.next = temp;
    }
}
