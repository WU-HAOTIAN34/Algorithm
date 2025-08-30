package com.leetcode;

public class LeeCo238Sol {
    public int[] productExceptSelf(int[] nums) {
        int a = 1;
        int zeroN = 0;
        int[] res = new int[nums.length];
        for (int i : nums){
            if (i==0){
                zeroN++;
            }else{
                a*=i;
            }
        }
        if (zeroN>1) return res;
        for (int i=0; i<nums.length; i++){
            if (zeroN==1 && nums[i]==0){
                res[i] = a;
            }else if (zeroN == 0){
                res[i] = a/nums[i];
            }
        }
        return res;
    }
}
