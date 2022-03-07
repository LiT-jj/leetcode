package Topic_03_二叉树;

import java.awt.List;
import java.util.*;

public class BM27_按之字形顺序打印二叉树 {


    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return res;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; ++i) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (flag){
                Collections.reverse(list);
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}
