package com.leetcode;

public class LeeCo41Sol {

    public int firstMissingPositive(int[] nums) {
        for (int i=0; i<nums.length; i++){
            if (nums[i]<=0 || nums[i]>nums.length) nums[i] = nums.length+1;
        }

        for (int i=0; i<nums.length; i++){
            int n = Math.abs(nums[i]);
            if (n>nums.length) continue;
            if (nums[n-1]>0){
                nums[n-1] *= -1;
            }
        }

        for (int i=0; i<nums.length; i++){
            if (nums[i]>0){
                return i+1;
            }
        }

        return nums.length+1;
    }
}
