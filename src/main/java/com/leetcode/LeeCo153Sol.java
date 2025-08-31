package com.leetcode;

public class LeeCo153Sol {

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while (l<r-1){
            int m = (r+l)/2;
            if ((nums[m]>=nums[l] && nums[r]>=nums[m]) || nums[m]<=nums[l]){
                r = m;
            }else{
                l = m;
            }
        }
        return Math.min(nums[l], nums[r]);
    }
}
