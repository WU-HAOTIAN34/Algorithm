package com.kamacoder;

import java.util.Scanner;

public class KaMa277Sol {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] c = sc.nextLine().split(" ");

        for (int i=0; i<n-1; i++){
            String[] c1 = c[i].split(":");
            String[] c2 = c[i+1].split(":");
            int h = Integer.parseInt(c2[0])-Integer.parseInt(c1[0]);
            int m = Integer.parseInt(c2[1])-Integer.parseInt(c1[1]);
            int s = Integer.parseInt(c2[2])-Integer.parseInt(c1[2]);
            if (s<0){
                m--;
                s+=60;
            }
            if (m<0){
                h--;
                m+=60;
            }
            if (h<0) h+=24;
            double res = (double)(h*60+m+s/60.0);

            System.out.printf("%.2f", res);
            if (i!=n-2) System.out.print(" ");
        }
    }
}
