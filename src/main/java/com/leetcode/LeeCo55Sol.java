package com.leetcode;

public class LeeCo55Sol {
    public boolean canJump(int[] nums) {
        int maxP = nums[0];
        int pos = 0;
        while (pos<=maxP && pos<nums.length){
            maxP = Math.max(maxP, pos+nums[pos]);
            pos++;
        }
        return maxP>=nums.length-1;
    }
}
