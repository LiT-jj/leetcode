package HOT100;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }

    public TreeNode() {
    }

    public static TreeNode create(Integer[] arr){
        if(arr.length == 0 || arr[0] == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);
        int curInedex = 0;
        while(queue.size() > 0 && curInedex< arr.length){
            TreeNode node = queue.poll();
            curInedex++;
            if (curInedex < arr.length && arr[curInedex] == null){
                node.left = null;
            } else if (curInedex < arr.length){
                TreeNode leftNode = new TreeNode(arr[curInedex]);
                node.left = leftNode;
                queue.offer(leftNode);
            } else {
                break;
            }
            curInedex++;
            if (curInedex < arr.length && arr[curInedex] == null){
                node.right = null;
            } else if(curInedex < arr.length){
                TreeNode rightNode = new TreeNode(arr[curInedex]);
                node.right = rightNode;
                queue.offer(rightNode);
            } else {
                break;
            }
        }
        while (queue.size() > 0){
            TreeNode node = queue.poll();
            node.right = null;
            node.left = null;
        }
        return root;
    }

}
