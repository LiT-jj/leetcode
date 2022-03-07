package HUAWEI;

import java.util.Arrays;
import java.util.Scanner;

public class HJ39判断两个IP是否属于同一子网 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String yanma=sc.nextLine();
            String ip1=sc.nextLine();
            String ip2=sc.nextLine();
            System.out.println(choice(yanma,ip1,ip2));;
        }
    }
    private static int choice(String yanma, String ip1, String ip2) {
        String[] yanma1=yanma.split("\\.");
        String[] ip11=ip1.split("\\.");
        String[] ip21=ip2.split("\\.");
        int[] yanmanum=new int[4];
        int[] ip1num=new int[4];
        int[] ip2num=new int[4];

        int[] num1=new int[4];
        int[] num2=new int[4];
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<4;i++){
            yanmanum[i]=Integer.parseInt(yanma1[i]);
            ip1num[i]=Integer.parseInt(ip11[i]);
            ip2num[i]=Integer.parseInt(ip21[i]);
            int len=Integer.toBinaryString(yanmanum[i]).length();
            for(int j=8;j>0;j--){
                if(len>=j){
                    sb.append(Integer.toBinaryString(yanmanum[i]));
                    break;
                }else {
                    sb.append("0");
                }
            }
        }
        char[] cs=sb.toString().toCharArray();
        Arrays.sort(cs);
        String css=new String(cs);
        String bss=new String(sb.reverse());
        if(!bss.equals(css)){
            return 1;
        }

        for(int i=0;i<4;i++){
            num1[i]=yanmanum[i]&ip1num[i];
            num2[i]=yanmanum[i]&ip2num[i];
            if(ip1num[i]<0||ip1num[i]>255||ip2num[i]<0||ip2num[i]>255||yanmanum[i]<0||yanmanum[i]>255){
                return 1;
            }
        }
        for(int i=0;i<4;i++){
            if(num1[i]!=num2[i]){
                return 2;
            }
        }
        return 0;
    }
}
