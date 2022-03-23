package Topic_01_链表;

public class LC_25_K个一组翻转链表 {
    public static void main(String[] args) {
        ListNode node = ListNode.createLinkerList(new int[]{1, 2, 3, 4, 5});
        new Solution().reverseKGroup(node, 2);

    }
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode new_head = new ListNode(), curNode, prevNode;
        new_head.next = head;
        curNode = head;
        prevNode = new_head;
        int index = 1;
        while(curNode!= null){
            //当前节点下标不为k的整数倍
            if (index % k != 0){
                index ++;
                curNode = curNode.next;
            } else {
                //当前节点下标为K的整数倍
                ListNode nextNode = curNode.next;
                curNode.next = null;
                ListNode tail = reverseNode(prevNode);
                prevNode = tail;
                curNode = nextNode;
                index++;
                tail.next = curNode;
            }
        }
        return new_head.next;
    }

    //反转链表，并将翻转后的链表的尾节点返回
    private ListNode reverseNode(ListNode prevNode) {
        ListNode head = new ListNode();
        ListNode p = prevNode.next;
        ListNode res = prevNode.next;
        while(p != null){
            ListNode temp = p.next;
            p.next = head.next;
            head.next = p;
            p = temp;
        }
        prevNode.next = head.next;
        return res;
    }
}
