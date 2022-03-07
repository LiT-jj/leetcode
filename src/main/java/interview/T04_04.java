package interview;

public class T04_04 {
    public static boolean isBalanced(TreeNode root){
        if(root == null)
            return true;
        int res = method(root);
        if (res == -1){
            return false;
        }
        return true;
    }
    public static int method(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftDepth = method(node.left);
        int rightDepth = method(node.right);
        if (leftDepth ==  -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        leftDepth++;
        rightDepth++;
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.create(new Integer[]{1, 2, 2, 3,null, null, 3, 4, null, null, 4});
        boolean res = isBalanced(root);
        System.out.println(res);

    }
}
