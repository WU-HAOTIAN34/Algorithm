package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeeCo228Sol {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums.length==0) return res;
        int be = nums[0];
        int end = nums[0];
        int p = 0;
        while (p<nums.length){
            if (nums[p]==end){
                end++;
                p++;
            }else{
                if (be==end-1){
                    res.add(""+be);
                }else{
                    res.add(be+"->"+(end-1));
                }
                be = nums[p];
                end = nums[p];
            }
        }
        if (be==end-1){
            res.add(""+be);
        }else{
            res.add(be+"->"+(end-1));
        }
        return res;

    }
}
