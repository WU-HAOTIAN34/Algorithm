package com.leetcode;

public class LeeCo169Sol {

    public int majorityElement(int[] nums) {
        int res = nums[0];
        int num = 1;
        for (int i=1; i<nums.length; i++){
            if (res != nums[i]){
                num--;
            }else{
                num++;
            }
            if (num<0){
                res = nums[i];
                num = 1;
            }
        }
        return res;
    }
}
