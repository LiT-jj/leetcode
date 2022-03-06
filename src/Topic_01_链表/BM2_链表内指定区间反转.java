package Topic_01_链表;


import java.util.Stack;

public class BM2_链表内指定区间反转 {
    /**
     * 思路：
     * step 1: 截取要反转的子串，并用preNode表示子串头节点的前缀，preNode.next表示子串末尾节点.next,并置子串末尾节点.next为null。
     * step 2: 利用头插法反转子串
     * step 3: 将反转的子串插入原来的串中
     * @param head
     * @param m
     * @param n 
     * @return
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode ZeroHead = new ListNode();
        ZeroHead.next = head;
        int currentIndex = 0;
        ListNode currentNode = ZeroHead;
        while((currentIndex + 1) != m){
            currentNode = currentNode.next;
            currentIndex++;
        }
        ListNode preNode = currentNode;
        ListNode p = preNode.next;
        currentNode = currentNode.next;
        currentIndex ++;
        while(currentIndex != n){
            currentNode = currentNode.next;
            currentIndex ++;
        }
        preNode.next = currentNode.next;
        currentNode.next = null;

        ListNode tempHead = new ListNode();
        while(p != null){
            ListNode temp = p;
            p = p.next;
            temp.next = tempHead.next;
            tempHead.next = temp;
        }
        p = tempHead.next;
        while(p.next != null){
            p = p.next;
        }
        p.next= preNode.next;
        preNode.next = tempHead.next;
        return ZeroHead.next;
    }

}
