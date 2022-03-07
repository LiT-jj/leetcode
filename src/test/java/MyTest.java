import Topic_03_二叉树.BM27_按之字形顺序打印二叉树;
import Topic_03_二叉树.TreeNode;
import Topic_07_动态规划.BM65_最长公共子序列2;
import org.junit.Test;

public class MyTest {
    @Test
    public void BM27(){
        TreeNode root = TreeNode.create(new Integer[]{8,6,10,5,7,9,11});
        BM27_按之字形顺序打印二叉树 bm27_按之字形顺序打印二叉树 = new BM27_按之字形顺序打印二叉树();
        bm27_按之字形顺序打印二叉树.Print(root);
    }

    @Test
    public void BM65(){
        String str1 = "1a1a31";
        String str2 = "1a231";
        BM65_最长公共子序列2 bm65_最长公共子序列2 = new BM65_最长公共子序列2();
        System.out.println(bm65_最长公共子序列2.LCS(str1, str2));
    }
}
