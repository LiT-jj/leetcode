package HUAWEI;

import java.util.Scanner;

public class HJ64MP3光标位置 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = Integer.valueOf(scanner.nextLine());
            String commands_str = scanner.nextLine();
            MP3 mp3 = new MP3(n);
            for(int i = 0; i < commands_str.length(); ++i){
                if (commands_str.charAt(i) == 'U'){
                    mp3.Up();
                } else {
                    mp3.Down();
                }
            }
            String page = "";
            for (int i = 0 ; i < mp3.page.length; ++i){
                page = page + " " + mp3.page[i];
            }
            System.out.println(page.trim());
            System.out.println(mp3.page[mp3.currentIndex]);
        }
    }
    static class MP3{
        int[] page;
        int[] music;
        int currentIndex;
        MP3(int n){
            this.music = new int[n];
            for (int i = 0; i < n; ++i){
                this.music[i] = i + 1;
            }
            this.page = new int[ 4 < n ? 4 : n];
            for (int i = 0; i < this.page.length; ++i){
                this.page[i] = i + 1;
            }
            this.currentIndex = 0;
        }
        void Up(){
            if (this.currentIndex == 0){
                if (this.page[this.currentIndex] == 1){
                    this.currentIndex = this.page.length - 1;
                    for (int i = this.page.length - 1; i >= 0; --i){
                        this.page[i] = this.music.length - this.page.length + i + 1;
                    }
                } else {
                    for (int i = 0; i < this.page.length; ++i){
                        this.page[i] --;
                    }
                }
            } else {
                this.currentIndex--;
            }
        }
        void Down(){
            if (this.currentIndex == this.page.length - 1){
                if (this.page[this.currentIndex] == this.music.length){
                    this.currentIndex = 0;
                    for (int i = 0; i < this.page.length; ++i){
                        this.page[i] = i + 1;
                    }
                } else {
                    for (int i = 0 ; i < this.page.length; ++i){
                        this.page[i] ++;
                    }
                }
            } else {
                this.currentIndex ++;
            }
        }
    }
}
