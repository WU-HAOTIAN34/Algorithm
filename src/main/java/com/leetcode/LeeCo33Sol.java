package com.leetcode;

public class LeeCo33Sol {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while(l<r){
            int middle = (l+r)/2;
            if(nums[middle]==target){
                return middle;
            }else if (nums[middle]>target && nums[l]<=target){
                r = middle;
            }else{
                l = middle+1;
            }
        }
        return -1;
    }

}
