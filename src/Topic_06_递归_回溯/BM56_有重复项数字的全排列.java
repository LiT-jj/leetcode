package Topic_06_递归_回溯;

import java.util.ArrayList;
import java.util.Arrays;


public class BM56_有重复项数字的全排列 {


    public void main(String[] args) {
        int[] num = new int[]{1, 1, 2};
        permuteUnique(num);
    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        //排序
        Arrays.sort(num);
        boolean[] flag = new boolean[num.length];
        ArrayList<Integer> list = new ArrayList<>();
        function(num, flag, list);
        return res;
    }

    private void function(int[] num, boolean[] flag, ArrayList<Integer> list) {
        if (list.size() == num.length){
            res.add((ArrayList<Integer>) list.clone());
            return;
        }

        for (int i = 0; i < num.length; ++i){
            //如果该数字用过，则开始下一轮循环
            if (flag[i]){
                continue;
            }
            //如果num[i] == num[i-1]且num[i-1]也没加入list（避免重复）
            if (i - 1 >= 0 && num[i] == num[i-1] && !flag[i-1]){
                continue;
            }
            list.add(num[i]);
            flag[i] = true;
            function(num, flag, list);

            flag[i] = false;
            list.remove(list.size()-1);
        }
    }

}
