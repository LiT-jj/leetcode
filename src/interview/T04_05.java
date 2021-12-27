package interview;

import java.util.LinkedList;
import java.util.List;

public class T04_05 {

    private  static Integer lastNum = null;
    public static boolean isValidBST(TreeNode root) {
        return DFS(root);
    }

    public static boolean DFS(TreeNode node){
        if(node == null){ return true; }
        if (!DFS(node.left)) return false;
        if (lastNum == null){
            lastNum = node.val;
        } else {
            if (node.val <= lastNum) return false;
            lastNum = node.val;
        }
        if (!DFS(node.right)) return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(new Integer[]{0, -1});
        boolean res = isValidBST(root);
        System.out.println(res);
    }
}
