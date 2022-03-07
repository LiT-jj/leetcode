package interview;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class T04_03 {
    public static void main(String[] args) {

    }

    static class Item{
        TreeNode treeNode;
        int level;
        Item(TreeNode node, int level){
            this.treeNode = node;
            this.level = level;
        }
    }
    public static int depth(TreeNode tree){
        if(tree == null)
            return 0;
        int left = depth(tree.left) + 1;
        int right = depth(tree.right) + 1;
        return left > right ? left : right;
    }
    public static ListNode[] listOfDepth(TreeNode tree) {
        Queue<Item> queue = new LinkedList<>();
        if (tree == null){
            return null;
        }
        queue.offer(new Item(tree, 0));
        int dep = depth(tree);
        ListNode[] listNodes = new ListNode[dep];
        ListNode[] p = new ListNode[dep];
        while(queue.size() > 0){
            Item item = queue.poll();
            TreeNode node = item.treeNode;
            ListNode temp = new ListNode(node.val);
            if (listNodes[item.level] == null){
                listNodes[item.level] = temp;
                p[item.level] = listNodes[item.level];
            } else {
                p[item.level].next = temp;
                p[item.level] = temp;
            }
            if (node.left != null){
                queue.offer(new Item(node.left, item.level + 1));
            }
            if (node.right != null){
                queue.offer(new Item(node.right, item.level + 1));
            }
        }
        return listNodes;
    }
}

