package com.kamacoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class KaMa290Sol {

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aNum = 0;
        int aMin = 100000;
        for (int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i]<aMin){
                aNum = i;
                aMin = a[i];
            }
        }
        int bNum = 0;
        int bMin = 100000;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            b[i] = Integer.parseInt(st.nextToken());
            if (b[i]<bMin){
                bNum = i;
                bMin = b[i];
            }
        }
        if (aNum!=bNum){
            System.out.println(Math.max(aMin, bMin));
            return;
        }
        int aSec = 100000;
        int bSec = 100000;
        for (int i=0; i<n; i++){
            if (i!=aNum){
                aSec = Math.min(aSec, a[i]);
            }
            if (i!=bNum){
                bSec = Math.min(bSec, b[i]);
            }
        }
        int res = Math.min(Math.max(aMin,bSec), Math.max(bMin,aSec));
        res = Math.min(res, aMin+bMin);
        System.out.println(res);

    }
}
