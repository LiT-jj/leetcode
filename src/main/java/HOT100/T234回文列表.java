package HOT100;

import java.util.ArrayList;

public class T234回文列表 {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList();
        ListNode p = head;
        while(p != null){
            list.add(p.val);
            p = p.next;
        }
        int len = list.size();
        for(int i = 0; i < len / 2; ++i){
            if(list.get(i) != list.get(len - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
