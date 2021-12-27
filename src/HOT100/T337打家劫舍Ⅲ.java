package HOT100;

import java.util.HashMap;

public class T337打家劫舍Ⅲ {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3, null, 1};
        TreeNode root = TreeNode.create(arr);
        rob(root);
        System.out.println(Math.max(f1.getOrDefault(root, 0),f2.getOrDefault(root, 0)));
    }
    static HashMap<TreeNode, Integer> f1 = new HashMap<TreeNode, Integer>();
    static HashMap<TreeNode, Integer> f2 = new HashMap<TreeNode, Integer>();

    public static int rob(TreeNode root) {
        DFS(root);
        return Math.max(f1.get(root), f2.get(root));
    }

    public static void DFS(TreeNode node){
        if(node == null){
            return ;
        }
        DFS(node.left);
        DFS(node.right);
        f1.put(node, node.val + f2.getOrDefault(node.left, 0) + f2.getOrDefault(node.right, 0));
        f2.put(node, Math.max(f1.getOrDefault(node.left, 0), f2.getOrDefault(node.left, 0)) + Math.max(f1.getOrDefault(node.right, 0), f2.getOrDefault(node.right, 0)));
    }
}
