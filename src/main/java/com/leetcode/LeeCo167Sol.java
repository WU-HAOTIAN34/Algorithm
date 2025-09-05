package com.leetcode;

public class LeeCo167Sol {

    public int[] twoSum(int[] numbers, int target) {
        int r = numbers.length-1;
        int l = 0;
        while (l<r){
            int t = numbers[l]+numbers[r];
            if (t==target){
                return new int[]{l+1, r+1};
            }else if (t<target){
                l++;
            }else{
                r--;
            }
        }
        return new int[]{};
    }
}
