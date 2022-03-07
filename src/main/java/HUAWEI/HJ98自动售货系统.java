package HUAWEI;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class HJ98自动售货系统 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            SaleSystem system = new SaleSystem();
            String[] commands = scanner.nextLine().split(";");
            for (int i = 0; i < commands.length; ++i){
                if (commands[i].startsWith("r")){
                    String info = commands[i].substring(2);
                    String[] infos = info.split(" ");
                    String[] huowu_info = infos[0].split("-");
                    String[] monney_info = infos[1].split("-");
                    int A1 = Integer.valueOf(huowu_info[0]);
                    int A2 = Integer.valueOf(huowu_info[1]);
                    int A3 = Integer.valueOf(huowu_info[2]);
                    int A4 = Integer.valueOf(huowu_info[3]);
                    int A5 = Integer.valueOf(huowu_info[4]);
                    int A6 = Integer.valueOf(huowu_info[5]);
                    int COIN_1 = Integer.valueOf(monney_info[0]);
                    int COIN_2 = Integer.valueOf(monney_info[1]);
                    int COIN_5 = Integer.valueOf(monney_info[2]);
                    int COIN_10 = Integer.valueOf(monney_info[3]);
                    system.init(A1, A2, A3, A4, A5, A6, COIN_1, COIN_2, COIN_5, COIN_10);
                } else if (commands[i].startsWith("p")){
                    int monney = Integer.valueOf(commands[i].substring(2));
                    system.coin(monney);
                } else if (commands[i].startsWith("b")){
                    String good = commands[i].substring(2);
                    system.buy(good);
                } else if (commands[i].startsWith("c")){
                    system.refund();
                } else if (commands[i].startsWith("q")){
                    if (commands[i].split(" ").length != 2){
                        System.out.println("E010:Parameter error");
                    } else {
                        int flag = Integer.valueOf(commands[i].split(" ")[1]);
                        system.inquire(flag);
                    }
                }
            }
        }

    }
    static class SaleSystem{
        private int A1 = 0;
        private int A2 = 0;
        private int A3 = 0;
        private int A4 = 0;
        private int A5 = 0;
        private int A6 = 0;
        private int COIN_1 = 0;
        private int COIN_2 = 0;
        private int COIN_5 = 0;
        private int COIN_10 = 0;
        private int balance = 0;
        private int[] price = new int[]{0, 2, 3, 4, 5, 8, 6};

        public void init(int A1, int A2, int A3, int A4, int A5, int A6, int COIN_1, int COIN_2, int COIN_5, int COIN_10){
            this.A1 = A1;
            this.A2 = A2;
            this.A3 = A3;
            this.A4 = A4;
            this.A5 = A5;
            this.A6 = A6;
            this.COIN_1 = COIN_1;
            this.COIN_2 = COIN_2;
            this.COIN_5 = COIN_5;
            this.COIN_10 = COIN_10;

            System.out.println("S001:Initialization is successful");
        }

        public void coin(int money){
            if (!(money == 1 || money == 2 || money == 5 || money == 10)){
                System.out.println("E002:Denomination error");
                return;
            } else {
                if ((money != 1 && money != 2) && 1*this.COIN_1 + 2*this.COIN_2 < money){
                    System.out.println("E003:Change is not enough, pay fail");
                    return;
                }
                if (this.A1 + this.A2 + this.A3 + this.A4 + this.A5 + this.A6 == 0){
                    System.out.println("E005:All the goods sold out");
                    return;
                }
                this.balance += money;
                if (money == 1){
                    this.COIN_1++;
                } else if (money == 2){
                    this.COIN_2++;
                } else if (money == 5){
                    this.COIN_5++;
                } else if (money == 10){
                    this.COIN_10++;
                }
                System.out.println(String.format("S002:Pay success,balance=%d", this.balance));
            }


        }

        public void buy(String good){
            switch (good){
                case "A1":
                    if (this.A1 == 0){
                        System.out.println("E007:The goods sold out");
                    } else if (this.balance < price[1]){
                        System.out.println("E008:Lack of balance");
                    } else {
                        this.A1--;
                        this.balance -= price[1];
                        System.out.println(String.format("S003:Buy success,balance=%d", this.balance));
                    }
                    break;
                case "A2":
                    if (this.A2 == 0){
                        System.out.println("E007:The goods sold out");
                    } else if (this.balance < price[2]){
                        System.out.println("E008:Lack of balance");
                    } else {
                        this.A2--;
                        this.balance -= price[2];
                        System.out.println(String.format("S003:Buy success,balance=%d", this.balance));
                    }
                    break;
                case "A3":
                    if (this.A3 == 0){
                        System.out.println("E007:The goods sold out");
                    } else if (this.balance < price[3]){
                        System.out.println("E008:Lack of balance");
                    } else {
                        this.A3--;
                        this.balance -= price[3];
                        System.out.println(String.format("S003:Buy success,balance=%d", this.balance));
                    }
                    break;
                case "A4":
                    if (this.A4 == 0){
                        System.out.println("E007:The goods sold out");
                    } else if (this.balance < price[4]){
                        System.out.println("E008:Lack of balance");
                    } else {
                        this.A4--;
                        this.balance -= price[4];
                        System.out.println(String.format("S003:Buy success,balance=%d", this.balance));
                    }
                    break;
                case "A5":
                    if (this.A5 == 0){
                        System.out.println("E007:The goods sold out");
                    } else if (this.balance < price[5]){
                        System.out.println("E008:Lack of balance");
                    } else {
                        this.A5--;
                        this.balance -= price[5];
                        System.out.println(String.format("S003:Buy success,balance=%d", this.balance));
                    }
                    break;
                case "A6":
                    if (this.A6 == 0){
                        System.out.println("E007:The goods sold out");
                    } else if (this.balance < price[6]){
                        System.out.println("E008:Lack of balance");
                    } else {
                        this.A6 --;
                        this.balance -= price[6];
                        System.out.println(String.format("S003:Buy success,balance=%d", this.balance));
                    }
                    break;
                default:
                    System.out.println("E006:Goods does not exist");
            }
        }

        public void refund(){
            if (this.balance == 0){
                System.out.println("E009:Work failure");
            } else {
                int num_COIN1 = 0;
                int num_COIN2 = 0;
                int num_COIN5 = 0;
                int num_COIN10 = 0;
                while(this.balance > 0){
                    if (this.balance >= 10 && this.COIN_10 > 0){
                        this.balance -= 10;
                        this.COIN_10--;
                        num_COIN10++;
                    } else if (this.balance >= 5 && this.COIN_5 > 0){
                        this.balance -= 5;
                        this.COIN_5--;
                        num_COIN5++;
                    } else if (this.balance >= 2 && this.COIN_2 > 0){
                        this.balance -= 2;
                        this.COIN_2 --;
                        num_COIN2++;
                    } else if (this.balance >= 1 && this.COIN_1 > 0){
                        this.COIN_1--;
                        this.balance -= 2;
                        num_COIN1++;
                    } else {
                        break;
                    }
                }
                this.balance = 0;
                System.out.println(String.format("1 yuan coin number=%d\n" +
                        "2 yuan coin number=%d\n" +
                        "5 yuan coin number=%d\n" +
                        "10 yuan coin number=%d", num_COIN1, num_COIN2, num_COIN5, num_COIN10));
            }
        }

        public void inquire(int flag){
            if (flag == 0){
                System.out.println(String.format("A1 2 %d\n" +
                        "A2 3 %d\n" +
                        "A3 4 %d\n" +
                        "A4 5 %d\n" +
                        "A5 8 %d\n" +
                        "A6 6 %d", this.A1, this.A2, this.A3, this.A4, this.A5, this.A6));
            } else {
                System.out.println(String.format("1 yuan coin number=%d\n" +
                        "2 yuan coin number=%d\n" +
                        "5 yuan coin number=%d\n" +
                        "10 yuan coin number=%d", this.COIN_1, this.COIN_2, this.COIN_5, this.COIN_10));
            }
        }
    }
}


