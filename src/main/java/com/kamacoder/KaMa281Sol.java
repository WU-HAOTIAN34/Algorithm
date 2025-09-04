package com.kamacoder;

import java.util.*;
import java.io.*;

public class KaMa281Sol {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][v+1];

        for (int i=0; i<=v; i++){
            if (i>=nums[0]){
                dp[0][i] = nums[0];
            }
        }

        for (int i=1; i<n; i++){
            for (int j=1; j<=v; j++){
                if (j>=nums[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(v-dp[n-1][v]);
    }
}
