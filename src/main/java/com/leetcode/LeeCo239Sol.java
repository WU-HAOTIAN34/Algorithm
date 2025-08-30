package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCo239Sol {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i=0; i<nums.length; i++){
            while (!dq.isEmpty() && dq.peekLast()<nums[i]) dq.pollLast();
            dq.add(nums[i]);
            if (i>=k-1){
                res[i-k+1] = dq.peekFirst();
                if (nums[i-k+1]==dq.peekFirst()) dq.pollFirst();
            }
        }
        return res;
    }
}
