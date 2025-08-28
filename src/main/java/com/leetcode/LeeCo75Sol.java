package com.leetcode;

public class LeeCo75Sol {

    public void sortColors(int[] nums) {
        int twoP = nums.length-1;
        int zeroP = 0;
        int i = 0;

        while (i<=twoP){
            if (nums[i]==0){
                while (zeroP<nums.length && nums[zeroP]==0) zeroP++;
                if (i>zeroP){
                    nums[i] = nums[zeroP];
                    nums[zeroP] = 0;
                }
            }else if (nums[i]==2){
                while (twoP>=0 && nums[twoP]==2) twoP--;
                if (i<twoP){
                    nums[i] = nums[twoP];
                    nums[twoP] = 2;
                }
            }
            if (nums[i]==1 || i<=zeroP){
                i++;
            }
        }

    }
}
