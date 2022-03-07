package Topic_01_链表;


public class BM3_链表中的节点每k个一组翻转 {


    /**
     * 思路：截取每隔k个结点得到一个新的链表，反转之后加入原来的结点，需要用prehead记录新链表的前驱结点方便新节点加入原始节点
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if (head == null){
            return null;
        }
        ListNode new_head = new ListNode();
        new_head.next = head;
        ListNode prehead = new_head;
        int currentIndex = 1;
        ListNode currentNode = head;
        while(currentNode.next != null){
            if (currentIndex % k == 0){
                ListNode temphead = prehead.next;
                prehead.next = currentNode.next;
                currentNode.next = null;
                temphead = reverse(temphead);
                ListNode endNode = temphead;
                while(endNode.next != null){
                    endNode = endNode.next;
                }
                endNode.next = prehead.next;
                prehead.next = temphead;
                prehead = endNode;
                currentNode = endNode;
            }
            currentNode = currentNode.next;
            currentIndex = currentIndex + 1;
        }
        return new_head.next;
    }

    public static ListNode reverse(ListNode node){
        ListNode head = new ListNode();
        head.next = null;

        while(node != null){
            ListNode temp = node;
            node = node.next;
            temp.next = head.next;
            head.next = temp;

        }
        return head.next;
    }
}
