package com.kamacoder;


import java.util.*;
import java.io.*;
public class KaMa292Sol {

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new  StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int now;
        int bef;
        int[] nums = new int[b];

        st = new StringTokenizer(br.readLine());
        bef = 0;
        for (int i=0; i<b; i++){
            now = Integer.parseInt(st.nextToken());
            nums[i] = now-bef;
            bef = now;
        }

        for (int i=1; i<a; i++){

            st = new StringTokenizer(br.readLine());
            bef = 0;
            for (int j=0; j<b; j++){
                now = Integer.parseInt(st.nextToken());
                nums[j] = Math.min(nums[j], now-bef);
                bef = now;
            }
        }

        int res = 0;
        for (int i=0; i<b; i++){
            res += nums[i];
        }

        System.out.println(res);
    }
}
