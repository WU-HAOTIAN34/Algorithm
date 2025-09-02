package com.kamacoder;

import java.util.Scanner;

public class KaMa285Sol {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        long p = Long.parseLong(tmp[0]);
        long x = Long.parseLong(tmp[1]);
        long y = Long.parseLong(tmp[2]);


        long a = Math.max(0, (long)Math.ceil((double)(x*p)/100.0)-y);
        long b = (long)Math.ceil((double)(x*Math.max(0, p-y))/100.0);

        System.out.println(Math.min(a, b));
    }
}
