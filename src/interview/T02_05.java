package interview;

public class T02_05 {
    public static void main(String[] args) {
        ListNode p1 = ListNode.createLinkerList(new int[]{5});
        ListNode p2 = ListNode.createLinkerList(new int[]{5});
        ListNode res = addTwoNumbers(p1, p2);
        ListNode.showListNode(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int num = num1 + num2 + carry;
            carry = num / 10;

            cur.next = new ListNode(num % 10);

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }
        if (carry == 1)
            cur.next = new ListNode(carry);
        return ans.next;
    }
}
