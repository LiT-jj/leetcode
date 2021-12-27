package interview;

public class T04_06 {
    public static TreeNode lastNum = null;
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return DFS(root, p);
    }

    public static TreeNode DFS(TreeNode node, TreeNode p){
        if (node == null){
            return null;
        }
        TreeNode leftRes = DFS(node.left, p);
        if (leftRes != null) return leftRes;
        if (lastNum != null && lastNum == p)
            return node;
        lastNum = node;
        TreeNode rightRes = DFS(node.right, p);
        if (rightRes != null) return rightRes;
        return null;
    }

    public static void main(String[] args) {
    }
}
