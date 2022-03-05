package Topic_01_链表;

public class BM1_反转链表 {
    public static void main(String[] args) {

    }

    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode p = head, new_head = new ListNode();
        do {
            ListNode temp = new ListNode(p.val);
            temp.next = new_head.next;
            new_head.next = temp;
            p = p.next;
        }while(p != null);
        return new_head.next;
    }
}
