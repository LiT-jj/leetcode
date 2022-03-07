package HUAWEI;

import org.omg.CORBA.MARSHAL;

import java.util.Random;
import java.util.Scanner;

public class HJ14字符串排序 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num_words = Integer.valueOf(scanner.nextLine());
        String[] words = new String[num_words];
        for(int i = 0; i < num_words; ++i){
            words[i] = scanner.nextLine();
        }
        sort(words);
        for(int i = 0; i < words.length; ++i){
            System.out.println(words[i]);
        }
    }

    public static void sort(String[] words){
        quickSort(words, 0, words.length - 1);
    }

    private static void quickSort(String[] words, int left, int right) {
        if (left >= right){
            return;
        }
        int partitionIndex = randomPartition(words, left, right);
        quickSort(words, left, partitionIndex - 1);
        quickSort(words, partitionIndex + 1, right);
    }

    private static int randomPartition(String[] words, int left, int right) {
        Random random= new Random();
        int random_num = random.nextInt(right - left + 1) + left;
        swap(words, random_num, right);
        return partition(words, left, right);
    }

    private static int partition(String[] words, int left, int right) {
        String x= words[right];
        int i = left;
        for (int j = left; j < words.length; ++j){
            if (compare(words[j], x) < 0){
                swap(words, i++, j);
            }
        }
        swap(words, right, i);
        return i;
    }

    private static int compare(String str1, String str2) {
        for (int i = 0; i < Math.min(str1.length(), str2.length());i++){
            if (str1.charAt(i) > str2.charAt(i)){
                return 1;
            } else if (str1.charAt(i) < str2.charAt(i)){
                return -1;
            }
        }
        if (str1.length() > str2.length()){
            return 1;
        } else if(str1.length() < str2.length()){
            return -1;
        } else {
            return 0;
        }
    }

    private static void swap(String[] words, int random_num, int right) {
        String temp = words[random_num];
        words[random_num] = words[right];
        words[right] = temp;
    }
}
