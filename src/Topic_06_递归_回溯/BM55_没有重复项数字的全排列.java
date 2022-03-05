package Topic_06_递归_回溯;

import java.util.ArrayList;

public class BM55_没有重复项数字的全排列 {
    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        int[] flag = new int[num.length];
        ArrayList<Integer> list = new ArrayList();
        function(num, flag, list);
        return arrayLists;
    }

    public void function(int[] num, int flag[], ArrayList<Integer> list){
        if (list.size() == num.length){
            arrayLists.add((ArrayList<Integer>) list.clone());
        }
        for (int i = 0; i < num.length; ++i){
            if (flag[i] == 0){
                flag[i] = 1;
                list.add(num[i]);
                function(num, flag, list);
                flag[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
