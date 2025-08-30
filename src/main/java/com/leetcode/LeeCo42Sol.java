package com.leetcode;

public class LeeCo42Sol {

    public int trap(int[] height) {
        int res = 0;
        int maxH = 0;
        int[] aft = new int[height.length];
        int[] bef = new int[height.length];
        for (int i=0; i<height.length; i++){
            bef[i] = Math.max(0, maxH-height[i]);
            maxH = Math.max(maxH, height[i]);
        }
        maxH = 0;
        for (int i=height.length-1; i>=0; i--){
            aft[i] = Math.max(0, maxH-height[i]);
            maxH = Math.max(maxH, height[i]);
            res += Math.min(aft[i], bef[i]);
        }
        return res;
    }
}
