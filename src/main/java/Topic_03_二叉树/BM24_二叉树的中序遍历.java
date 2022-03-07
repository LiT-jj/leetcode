package Topic_03_二叉树;

import java.util.LinkedList;
import java.util.List;

public class BM24_二叉树的中序遍历 {
    public int[] inorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = new LinkedList<>();
        DFS(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; ++i){
            res[i] = list.get(i);
        }
        return res;
    }

    private void DFS(TreeNode node, List<Integer> list) {
        if (node == null){
            return;
        }
        DFS(node.left, list);
        list.add(node.val);
        DFS(node.right, list);
    }
}
