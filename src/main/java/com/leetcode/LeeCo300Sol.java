package com.leetcode;

public class LeeCo300Sol {

    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            dp[i] = 1;
            for (int j=0; j<i; j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
