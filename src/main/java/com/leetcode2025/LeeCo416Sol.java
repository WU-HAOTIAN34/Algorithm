package com.leetcode2025;

public class LeeCo416Sol {

    public boolean canPartition(int[] nums) {
        int numSum = 0;
        for (int i : nums){
            numSum += i;
        }
        if (numSum%2!=0){
            return false;
        }else{
            numSum /= 2;
        }

        boolean[][] dp = new boolean[nums.length][numSum+1];

        if (numSum>=nums[0]) dp[0][nums[0]] = true;
        for (int i=0; i<nums.length; i++){
            dp[i][0] = true;
        }

        for (int i=1; i<nums.length; i++){
            for (int j=1; j<=numSum; j++){
                if (j>=nums[i]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[nums.length-1][numSum];
    }
}
