package HOT100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class T297序列化与反序列化 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{};
        TreeNode root = TreeNode.create(array);
        String res = serialize(root);
        root = deserialize(res);
        System.out.println();
    }

    public static String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<String> string_queue = new LinkedList<String>();
        queue.offer(root);
        string_queue.offer(root.val + "");
        while(queue.isEmpty() == false){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
                string_queue.offer(node.left.val + "");
            } else {
                string_queue.offer("null");
            }
            if(node.right != null){
                queue.offer(node.right);
                string_queue.offer(node.right.val + "");
            } else {
                string_queue.offer("null");
            }
        }
        String res = "";
        while(string_queue.isEmpty() == false){
            res += string_queue.poll() + ",";
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        String[] node_val = data.split(",");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(node_val[0]));
        queue.offer(root);
        int i = 1;
        while(queue.isEmpty() == false){
            TreeNode node = queue.poll();
            if(i >= node_val.length || node_val[i].equals("null")){
                node.left = null;
            } else {
                TreeNode left_node = new TreeNode(Integer.parseInt(node_val[i]));
                node.left = left_node;
                queue.offer(left_node);
            }
            i++;
            if(i >= node_val.length || node_val[i].equals("null")){
                node.right = null;
            } else {
                TreeNode right_node = new TreeNode(Integer.parseInt(node_val[i]));
                node.right = right_node;
                queue.offer(right_node);
            }
            i++;
        }
        return root;
    }
}
