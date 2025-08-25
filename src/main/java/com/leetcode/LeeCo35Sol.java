package com.leetcode;

public class LeeCo35Sol {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if (nums[m]>=target){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return l;
    }
}
