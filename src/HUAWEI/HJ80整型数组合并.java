package HUAWEI;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class HJ80整型数组合并 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] group1 = new int[n];
            for(int i = 0; i < n; ++i){
                group1[i] = scanner.nextInt();
            }
            n = scanner.nextInt();
            int[] group2 = new int[n];
            for(int i = 0 ; i < n; ++i){
                group2[i] = scanner.nextInt();
            }
            sort(group1);
            sort(group2);
            List<Integer> list = new LinkedList<>();
            int i = 0, j = 0 , k = 0;
            while(i < group1.length && j < group2.length){
                if(group1[i] < group2[j]){
                    if(list.size() == 0 || group1[i] != list.get(list.size() - 1)){
                        list.add(group1[i]);
                    }
                    i++;
                } else if(group2[j] < group1[i]){
                    if(list.size() == 0 ||group2[j] != list.get(list.size() - 1)){
                        list.add(group2[j]);
                    }
                    j++;
                } else{
                    if(list.size() == 0 || group2[j] != list.get(list.size() - 1)){
                        list.add(group2[j]);
                    }
                    i++;
                    j++;
                }
            }
            while(i < group1.length){
                if(group1[i] != list.get(list.size() - 1)){
                    list.add(group1[i]);
                }
                i++;
            }
            while(j < group2.length){
                if(group2[j] != list.get(list.size() - 1)){
                    list.add(group2[j]);
                }
                j++;
            }
            for(int m = 0; m < list.size(); ++m){
                System.out.print(list.get(m));
            }
            System.out.println();
        }
    }
    public static void sort(int[] nums){
        int temp;//定义一个临时变量
        for(int i = 0;i < nums.length - 1; i++){//冒泡趟数
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j+1] < nums[j]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

    }
}
