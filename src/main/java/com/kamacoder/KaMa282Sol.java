package com.kamacoder;

import java.util.Scanner;

public class KaMa282Sol {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int res = 0;
        for(int i=0; i<4; i++){
            int t = s[0].charAt(i)-s[1].charAt(i);
            if (t<0){
                res+=10-Math.abs(t);
            }else{
                res+=t;
            }
        }
        System.out.println(res);
    }
}
