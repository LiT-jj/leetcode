package HUAWEI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ8合并表记录 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer,Integer>  map = new TreeMap<>();
        while(sc.hasNext()){
            int n = sc.nextInt();
            for(int i =0;i<n;i++){
                int key = sc.nextInt();
                int value = sc.nextInt();
                map.put(key,map.getOrDefault(key,0)+value);
            }
            for(Integer i : map.keySet()){
                System.out.println(i+" "+map.get(i));
            }
        }
    }
}
