package com.leetcode2025;

public class LeeCo34Sol {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int t = -1;
        while (l<=r){
            int middle = (l+r) / 2;
            if (nums[middle] == target){
                t = middle;
                break;
            }else if(nums[middle]>target){
                r = middle-1;
            }else{
                l = middle+1;
            }
        }
        if (t==-1){
            return new int[]{t,t};
        }
        int r2 = t;
        while (l<=r2){
            int middle = (l+r2) / 2;
            if (nums[middle]<target){
                l = middle+1;
            }else{
                r2 = middle-1;
            }
        }
        int l2 = t;
        while (l2<=r){
            int middle = (l2+r) / 2;
            if (nums[middle]<=target){
                l2 = middle+1;
            }else{
                r = middle-1;
            }
        }
        return new int[]{r2+1, l2-1};
    }
}
