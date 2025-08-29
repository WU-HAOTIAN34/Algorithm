package com.leetcode;

public class LeeCo121Sol {

    public int maxProfit(int[] prices) {
        int now = Integer.MAX_VALUE;
        int res = 0;
        for (int i=0; i<prices.length; i++){
            res= Math.max(res, prices[i]-now);
            now = Math.min(now, prices[i]);
        }
        return res;
    }
}
