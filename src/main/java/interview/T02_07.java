package interview;

public class T02_07 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;

        while (h1 != h2) {

            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }

        return h1;
    }

    public static ListNode create(int[] arr){
        if(arr.length == 0) {
            return null;
        }
        ListNode head = null, p = null;
        for(int i= 0; i < arr.length; ++i){
            if(head == null){
                head = new ListNode(arr[i]);
                p = head;
            } else {
                ListNode temp = new ListNode(arr[i]);
                p.next = temp;
                p = temp;
            }

        }
        return head;
    }

    public static void showListNode(ListNode head){
        ListNode p = head;
        while(p!=null){
            System.out.println(String.valueOf(p.val) + " ");
            p = p.next;
        }

    }

    public static void main(String[] args) {
        int[] arrA = new int[]{4, 1, 8, 4, 5};
        int[] arrB = new int[]{5, 0, 1, 8, 4, 5};
        ListNode listA = create(arrA);
        ListNode listB = create(arrB);
        ListNode inset = getIntersectionNode(listA, listB);
        showListNode(inset);
        }
}
