package com.leetcode;

public class LeeCo274Sol {

    public int hIndex(int[] citations) {
        int[] nums = new int[1001];
        for (int i : citations){
            nums[i]++;
        }
        int sumN = 0;
        int res;
        for (res=nums.length-1; res>=0; res--){
            sumN += nums[res];
            if (sumN>=res) break;
        }
        return res;
    }
}
