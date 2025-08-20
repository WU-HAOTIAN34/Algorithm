package com.leetcode2025;

public class LeeCo279Sol {

    public int numSquares(int n) {
        int num = (int) Math.sqrt((double) n);
        int[][] dp = new int[num][n+1];

        for (int i=1; i<=n; i++){
            dp[0][i] = i;
        }

        for (int i=1; i<num; i++){
            for (int j=1; j<=n; j++){
                int tmp = (int) Math.pow((double) (i+1), 2.0);
                if (j>=tmp){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-tmp]+1);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[num-1][n];
    }
}
