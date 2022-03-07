package Topic_03_二叉树;

import java.util.LinkedList;
import java.util.List;

public class BM25_二叉树的后序遍历 {
    List<Integer> list = new LinkedList<>();
    public int[] postorderTraversal (TreeNode root) {
        DFS(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; ++i){
            res[i] = list.get(i);
        }
        return res;
    }

    private void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        DFS(root.left);
        DFS(root.right);
        list.add(root.val);
    }
}
