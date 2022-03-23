import Topic_03_二叉树.BM27_按之字形顺序打印二叉树;
import Topic_03_二叉树.TreeNode;
import Topic_06_递归_回溯.BM57_岛屿数量;
import Topic_07_动态规划.*;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void BM27(){
        TreeNode root = TreeNode.create(new Integer[]{8,6,10,5,7,9,11});
        BM27_按之字形顺序打印二叉树 bm27_按之字形顺序打印二叉树 = new BM27_按之字形顺序打印二叉树();
        bm27_按之字形顺序打印二叉树.Print(root);
    }


    @Test
    public void BM65(){
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        BM65_最长公共子序列2 bm65_最长公共子序列2 = new BM65_最长公共子序列2();
        System.out.println(bm65_最长公共子序列2.LCS(str1, str2));
    }

    @Test
    public void BM66(){
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        BM66_最长公共子串 bm66_最长公共子串 = new BM66_最长公共子串();
        System.out.println(bm66_最长公共子串.LCS(str1, str2));
    }

    @Test
    public void BM68(){
        int[][] matrix = new int[][]{{1,3,5,9}, {8,1,3,4}, {5,0,6,1}, {8,8,4,0}};
        BM68_矩阵的最小路径和 bm68_矩阵的最小路径和 = new BM68_矩阵的最小路径和();
        bm68_矩阵的最小路径和.minPathSum(matrix);
    }

    @Test
    public void BM69(){
        BM69_把数字翻译成字符串 bm69_把数字翻译成字符串 = new BM69_把数字翻译成字符串();
        System.out.println(bm69_把数字翻译成字符串.solve("10"));
    }

    @Test
    public void BM70(){
        BM70_兑换零钱1 bm70_兑换零钱1 = new BM70_兑换零钱1();
        System.out.println(bm70_兑换零钱1.minMoney(new int[]{5, 2, 3}, 0));
    }

    @Test
    public void BM71(){
        BM71_最长上升子序列1 bm71_最长上升子序列1 = new BM71_最长上升子序列1();
        System.out.println(bm71_最长上升子序列1.LIS(new int[]{1,6,4,7,5,3,2}));
    }


    @Test
    public void BM72(){
        BM72_连续子数组的最大和 bm72_连续子数组的最大和 = new BM72_连续子数组的最大和();
        System.out.println(bm72_连续子数组的最大和.FindGreatestSumOfSubArray(new int[]{2,8,1,5,9}));
    }

    @Test
    public void BM73(){
        BM73_最长回文子串 bm73_最长回文子串 = new BM73_最长回文子串();
        System.out.println(bm73_最长回文子串.getLongestPalindrome("bb"));
    }

    @Test
    public void BM75(){
        BM75_编辑距离1 bm75_编辑距离1 = new BM75_编辑距离1();
        System.out.println(bm75_编辑距离1.editDistance("new", "nowcoder"));
    }

    @Test
    public void BM76(){
        String str1 = "ba";
        String str2 = "a*";
        BM76_正则表达式匹配 bm76_正则表达式匹配 = new BM76_正则表达式匹配();
        System.out.println(bm76_正则表达式匹配.match(str1, str2));
    }

    @Test
    public void BM77(){
        BM77_最长的括号子串 bm77_最长的括号子串 = new BM77_最长的括号子串();
        System.out.println(bm77_最长的括号子串.longestValidParentheses("())"));
    }

    @Test
    public void BM79(){
        BM79_打家劫舍2 bm79_打家劫舍2 = new BM79_打家劫舍2();
        System.out.println(bm79_打家劫舍2.rob(new int[]{43, 4, 4, 1, 26, 29, 24, 44, 52, 1}));
    }
    @Test
    public void BM82(){
        BM82_买卖股票的最好时机3 bm82_买卖股票的最好时机3 = new BM82_买卖股票的最好时机3();
        System.out.println(bm82_买卖股票的最好时机3.maxProfit(new int[]{8, 9, 3, 5, 1, 3}));
    }

    @Test
    public void testIterable(){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 100);
        map.put(2, 200);
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testScanner(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            String s = scanner.nextLine();
            System.out.println(String.format("%d-%d-%s", a, b, s));
        }
    }
}
