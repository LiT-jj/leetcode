package HOT100;


public class T543二叉树的直径 {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5};
        TreeNode root = TreeNode.create(a);
        System.out.println(diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        Info info = DFS(root);
        return Math.max(info.num1, info.num2);
    }

    public static Info DFS(TreeNode node){
        if(node == null){
            return new Info(0, 0);
        }
        Info left = DFS(node.left);
        Info right = DFS(node.right);
        int num1 = Math.max(left.num1, right.num1);
        if (node.left != null || node.right != null)
            num1++;

        int num2 = left.num1 + right.num1;
        if (node.left != null)
            num2++;
        if (node.right != null)
            num2++;

        int num3 = left.num2 > right.num2 ? left.num2 : right.num2;

        return new Info(num1, Math.max(num2, num3));
    }

    static class Info{
        int num1;
        int num2;

        Info(int num1, int num2){
            this.num1 = num1;
            this.num2 = num2;
        }
    }
}
