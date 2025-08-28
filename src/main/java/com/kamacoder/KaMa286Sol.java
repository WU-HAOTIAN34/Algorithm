package com.kamacoder;
import java.io.*;
import java.util.*;

public class KaMa286Sol {

    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[][] nums = new long[n][3];
        long[] factor = new long[2];
        int res = 0;

        for (int i=0; i<n; i++){
            nums[i][0] = Long.parseLong(st.nextToken());
            long a = nums[i][0];
            while (a%5==0){
                a/=5;
                nums[i][1]++;
                factor[0]++;
            }
            while (a%2==0){
                a/=2;
                nums[i][2]++;
                factor[1]++;
            }
        }
        res = Math.max(res, (int)Math.min(factor[0], factor[1]));

        for (int i=0; i<n; i++){
            long a = nums[i][0]+1;
            int five = 0;
            int two = 0;
            while (a%5==0){
                a/=5;
                five++;
            }
            while (a%2==0){
                a/=2;
                two++;
            }
            res = Math.max(res, (int)Math.min(factor[0]-nums[i][1]+five, factor[1]-nums[i][2]+two));
        }

        System.out.println(res);

    }
}
