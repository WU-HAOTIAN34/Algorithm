package com.leetcode;

public class LeeCo33Sol {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l<=r){
            int m = (l+r)/2;
            if (nums[m]==target){
                return m;
            }else if ((nums[m]>target && nums[l]<=target) ||
                    (nums[m]>target && nums[l]>nums[m]) || (nums[l]<=target && nums[l]>nums[m])){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return -1;
    }

}
