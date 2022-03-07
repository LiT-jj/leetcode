package HOT100;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
    ListNode(){ }

    public static ListNode creatCircleListNode(int[] arr, int pos){
        ListNode head = null;
        ListNode p = null;
        ListNode start = null;
        for(int i = 0; i < arr.length; ++i){
            if(head == null){
                head = new ListNode(arr[i]);
                p = head;
            } else{
                ListNode temp = new ListNode(arr[i]);
                p.next = temp;
                p = p.next;
            }
            if(i == pos){
                start = p;
            }
        }
        if(pos != -1){
            p.next = start;
        }
        return head;
    }
    public static ListNode createLinkerList(int[] arr){
        ListNode head = null;
        ListNode p = null;
        for (int i = 0; i < arr.length; ++i){
            if (head == null){
                head = new ListNode(arr[i]);
                p = head;
            } else {
                ListNode temp = new ListNode(arr[i]);
                p.next = temp;
                p = p.next;
            }
        }
        return head;
    }

    public static void showListNode(ListNode p){
        while(p != null){
            System.out.print(p.val);
            p = p.next;
        }
    }
}