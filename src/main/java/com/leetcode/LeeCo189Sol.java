package com.leetcode;

public class LeeCo189Sol {

    public void rotate(int[] nums, int k) {
        k%=nums.length;
        int tmp = nums[0];
        int pos = k;
        int n = 0;
        int i = 0;
        while (n<nums.length){
            tmp = nums[i];
            pos = (k+i)%nums.length;
            do {
                int a = nums[pos];
                nums[pos] = tmp;
                tmp = a;
                pos = (pos+k) % nums.length;
                n++;
            }while (pos != (k+i)%nums.length);
            i++;
        }


    }
}
