package com.leetcode2025;

public class LeeCo198Sol {

    public int rob(int[] nums) {
        int[] res = new int[nums.length+2];
        for (int i=2; i<nums.length+2; i++){
            res[i] = Math.max(res[i-1], res[i-2]+nums[i-2]);
        }
        return res[nums.length+1];
    }
}
