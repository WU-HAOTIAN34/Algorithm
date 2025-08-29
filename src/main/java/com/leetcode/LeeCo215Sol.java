package com.leetcode;

import java.util.PriorityQueue;

public class LeeCo215Sol {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums){
            if (pq.size()<k){
                pq.add(i);
            }else if (pq.peek()<i){
                pq.poll();
                pq.add(i);
            }
        }
        return pq.peek();

    }
}
