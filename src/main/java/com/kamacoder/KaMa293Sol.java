package com.kamacoder;

import java.util.Scanner;

public class KaMa293Sol {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] nums = new int[n];

        for (int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();


            if (a>2){
                nums[i] = 2*b;
            }else if(a==2){
                nums[i] = b;
            }
        }

        String res = "";
        for (int i=0; i<n; i++){
            res += nums[i];
            if (i!=n-1){
                res+=" ";
            }
        }
        System.out.println(res);
    }
}
