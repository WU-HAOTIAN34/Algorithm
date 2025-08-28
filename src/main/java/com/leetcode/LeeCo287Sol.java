package com.leetcode;

public class LeeCo287Sol {

    public int findDuplicate(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        do {
            p1 = nums[p1];
            p2 = nums[p2];
            p2 = nums[p2];
        }while (nums[p1]!=nums[p2]);
        p2 = 0;
        while (nums[p1]!=nums[p2]){
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return nums[p1];
    }
}
