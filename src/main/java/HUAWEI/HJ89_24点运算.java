package HUAWEI;

import java.util.*;

public class HJ89_24点运算 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.indexOf("JOKER") != -1 || str.indexOf("joker") != -1){
            System.out.println("ERROR");
        } else {
            String[] cards = str.split(" ");
            int[] nums = cards2nums(cards);
            int[] flag = new int[4];
            TreeNode root = new TreeNode(0, '+', null);
            TreeNode node = function(nums, flag, 0, root);
            String res = "";
            if (node == null){
                System.out.println("NONE");
            } else {
                while(node != null && node.num != 0){
                    int num = node.num;
                    String str_num = "";
                    if (num == 1){
                        str_num = "A";
                    } else if (num == 11){
                        str_num = "J";
                    } else if (num == 12){
                        str_num = "Q";
                    } else if (num == 13){
                        str_num = "K";
                    } else {
                        str_num = String.valueOf(num);
                    }
                    res = String.valueOf(node.opt) + str_num + res;
                    node = node.father;
                }
                System.out.println(res.substring(1));
            }
        }
    }

    private static TreeNode function(int[] nums, int[] flag, int num, TreeNode node) {
          char[] operations = new char[]{'+', '-', '*', '/'};
        if (flag[0] + flag[1] + flag[2] + flag[3] == 4){
            if (num == 24){
                return node;
            } else {
                return null;
            }
        }
        for (int i = 0; i < nums.length; ++i){
            //nums位置为i的卡片没使用过
            if (flag[i] == 0){
                flag[i] = 1;
                TreeNode res = null;
                if (flag[0] + flag[1] + flag[2] + flag[3] == 1){
                    int next_node_num = num + nums[i];
                    TreeNode temp = new TreeNode(nums[i], '+', node);
                    res = function(nums, flag, next_node_num, temp);
                } else {
                    for (int j = 0; j < operations.length && res == null; ++j){
                        TreeNode temp = new TreeNode(nums[i], operations[j], node);
                        int next_node_num = num;
                        switch (operations[j]){
                            case('+'):
                                next_node_num = num + nums[i];
                                break;
                            case('-'):
                                next_node_num = num - nums[i];
                                break;
                            case('*'):
                                next_node_num = num * nums[i];
                                break;
                            case('/'):
                                next_node_num = num / nums[i];
                                break;
                        }
                        res = function(nums, flag, next_node_num, temp);
                        if (res != null){
                            break;
                        }
                    }
                }

                if (res != null){
                    return res;
                }
                flag[i] = 0;
            }
        }
        return null;
    }

    private static int[] cards2nums(String[] cards) {
        int nums[] = new int[4];
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals("A")){
                nums[i] = 1;
            } else if (cards[i].equals("J")){
                nums[i] = 11;
            } else if (cards[i].equals("Q")){
                nums[i] = 12;
            } else if (cards[i].equals("K")){
                nums[i] = 13;
            } else {
                nums[i] = Integer.valueOf(cards[i]);
            }
        }
        return nums;
    }

    static class TreeNode{
        int num;
        char opt;
        TreeNode father;


        public TreeNode(int num, char operation, TreeNode node) {
            this.num = num;
            this.opt = operation;
            this.father = node;
        }
    }
}
