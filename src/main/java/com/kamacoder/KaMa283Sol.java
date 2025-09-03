package com.kamacoder;

import java.util.*;
import java.io.*;

public class KaMa283Sol {

    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[][] nums = new long[2][n];
        for (int i=0; i<n; i++){
            nums[0][i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            nums[1][i] = Long.parseLong(st.nextToken());
        }

        int res = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i=1; i<n; i++){
            long a = nums[0][i]-nums[0][i-1];
            long b = nums[1][i]-nums[1][i-1];
            if (a*b>=0 && Math.abs(a)==Math.abs(b)){
                dp[i] = dp[i-1]+1;
            }
            res = Math.max(dp[i], res);
        }

        System.out.println(res);

    }
}
