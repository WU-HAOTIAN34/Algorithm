package com.leetcode;

public class LeeCo31Sol {

    public void nextPermutation(int[] nums) {
        int p = nums.length-2;
        for ( ; p>=0; p--){
            if (nums[p+1]>nums[p]) break;
        }
        if (p<0){
            for (int i=0; i<nums.length/2; i++){
                int tmp = nums[i];
                nums[i] = nums[nums.length-1-i];
                nums[nums.length-1-i] = tmp;
            }
            return;
        }
        for (int i=nums.length-1; i>p; i--){
            if (nums[i]>nums[p]){
                int tmp = nums[p];
                nums[p] = nums[i];
                nums[i] = tmp;
                break;
            }
        }
        for (int i=0; i<nums.length-1-p-1; i++){
            for (int j=p+1; j<nums.length-1-i; j++){
                if (nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }

    }
}
