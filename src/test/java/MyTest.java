import Topic_03_二叉树.BM27_按之字形顺序打印二叉树;
import Topic_03_二叉树.TreeNode;
import Topic_07_动态规划.*;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

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
}
