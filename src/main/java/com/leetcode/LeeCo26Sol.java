package com.leetcode;

public class LeeCo26Sol {

    public int removeDuplicates(int[] nums) {
        int res = 0;
        int p = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==nums[p]){
                continue;
            }else{
                p++;
                nums[p] = nums[i];
                res++;
            }
        }
        return res+1;

    }
}
