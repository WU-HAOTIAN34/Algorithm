package com.leetcode;

public class LeeCo53Sol {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = Math.max(nums[0], 0);
        for (int i=1; i<nums.length; i++) {
            res = Math.max(res, nums[i]);
            if (dp[i - 1] + nums[i] > 0) {
                dp[i] = dp[i - 1] + nums[i];
                res = Math.max(dp[i], res);
            } else {
                dp[i] = 0;
            }
        }
        return res;
    }
}
