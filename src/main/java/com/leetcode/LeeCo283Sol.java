package com.leetcode;

public class LeeCo283Sol {

    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==0){
                while (p<nums.length && nums[p]==0) p++;
                if (p>=nums.length) break;
                nums[i] = nums[p];
                nums[p] = 0;
            }else{
                p++;
            }
        }
    }
}
