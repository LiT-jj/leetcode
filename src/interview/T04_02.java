package interview;

public class T04_02 {


    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        return insert(nums, 0, nums.length - 1);
    }

    public static TreeNode insert(int[] nums, int left, int right){
        int length = right - left;
        if(length == 0){
            TreeNode node = new TreeNode(nums[right]);
            node.left = null;
            node.right = null;
            return node;
        } else if (length > 0){
            int mid = (int) Math.round((right + left) / 2.0);
            TreeNode root = new TreeNode(nums[mid]);
            root.left = insert(nums, left, mid - 1);
            root.right = insert(nums, mid + 1, right);
            return root;
        } else{
            return null;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-10, -3, 0, 5, 9};
        TreeNode node = sortedArrayToBST(arr);
        System.out.println(node);
    }
}


