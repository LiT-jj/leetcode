package interview;

public class T04_08 {
    public static Integer num = 0;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Integer num = new Integer(0);
        TreeNode res = DFS(root, p, q);
        return res;
    }

    public static TreeNode DFS(TreeNode node, TreeNode p , TreeNode q){
        if (node == null)
            return null;
        TreeNode leftRes = DFS(node.left, p, q);
        TreeNode rightRes = DFS(node.right, p, q);
        if (node == p || node == q || num == 2){
           if (num == 2 && (leftRes == null || rightRes == null)){
               return leftRes == null ? rightRes : leftRes;
           }
           if (num < 2)
               num++;
           return node;
        }
        if (rightRes != null || leftRes != null){
            return leftRes == null ? rightRes : leftRes;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(new Integer[]{1, 2, 3, null, 4});
        TreeNode res = lowestCommonAncestor(root, root.left.right, root.right);
        System.out.println(res.val);
    }
}
