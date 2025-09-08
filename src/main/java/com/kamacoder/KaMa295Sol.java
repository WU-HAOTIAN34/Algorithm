package com.kamacoder;

import java.util.*;
import java.io.*;
public class KaMa295Sol {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(nums);
        long res = 0;
        long number = n;
        for (int i=0; i<n; i++){
            res += number*nums[nums.length-1-i];
            if (i%2==1){
                number = (long) (i/2+2)*(n-1-i/2);
            }
        }
        System.out.println(res);
    }
}
