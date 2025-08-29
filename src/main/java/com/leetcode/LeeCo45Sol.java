package com.leetcode;

public class LeeCo45Sol {

    public int jump(int[] nums) {
        if (nums.length==1) return 0;
        int res = 0;
        int maxP = nums[0];
        int pos = 0;
        while (maxP<nums.length-1){
            res++;
            int n = maxP-pos;
            while (n>0 && maxP<nums.length-1){
                pos++;
                maxP = Math.max(pos+nums[pos], maxP);
                n--;
            }
        }
        return res+1;
    }
}
