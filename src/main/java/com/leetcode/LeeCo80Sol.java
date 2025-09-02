package com.leetcode;

public class LeeCo80Sol {

    public int removeDuplicates(int[] nums) {
        int[] con = new int[20001];
        int res = 0;
        int p = 0;
        for (int i=0; i<nums.length; i++){
            if (con[nums[i]+10000]>=2){
                continue;
            }else{
                nums[p] = nums[i];
                p++;
                con[nums[i]+10000]++;
                res++;
            }
        }
        return res;
    }
}
