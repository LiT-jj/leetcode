package Topic_03_二叉树;


import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
 

public class BM23_二叉树的前序遍历 {
    public int[] preorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = new LinkedList<>();
        DFS(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i){
            res[i] = list.get(i);
        }
        return res;
    }

    private void DFS(TreeNode root, List<Integer> list) {
        if (root == null){
            return;
        }
        list.add(root.val);
        DFS(root.left, list);
        DFS(root.right, list);
    }
}
