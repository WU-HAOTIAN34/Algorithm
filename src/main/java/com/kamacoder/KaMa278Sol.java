package com.kamacoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KaMa278Sol {

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] str = new String[n][3];
        for (int i=0; i<n; i++) str[i] = br.readLine().split(" ");
        for (int i=0; i<n; i++){
            String[] c = str[i];
            long a = Long.parseLong(c[0]);
            long b = Long.parseLong(c[1]);
            double re1 = 0;
            double re2 = 0;
            if (c[2].equals("+") || c[2].equals("*")){
                System.out.println("=");
                continue;
            }else if (c[2].equals("-") || c[2].equals("/")){
                re1 = a;
                re2 = b;
            }else{
                re1 = Math.log(a)*b;
                re2 = Math.log(b)*a;
            }
            if (re1==re2){
                System.out.println("=");
            }else if (re1>re2){
                System.out.println(">");
            }else{
                System.out.println("<");
            }
        }
    }
}
