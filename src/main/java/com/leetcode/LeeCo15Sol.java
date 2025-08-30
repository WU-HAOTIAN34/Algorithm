package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeeCo15Sol {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++){
            int fir = i+1;
            int sec = nums.length-1;
            while (fir<sec){
                int s = nums[i]+nums[fir]+nums[sec];
                if (s==0){
                    res.add(Arrays.asList(nums[i], nums[fir], nums[sec]));
                    do{
                        fir++;
                    }while (fir<sec && nums[fir]==nums[fir-1]);
                }else if (s<0){
                    fir++;
                }else{
                    sec--;
                }
            }
            while (i+1<nums.length && nums[i]==nums[i+1]) i++;
        }
        return res;
    }
}
