package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeeCo347Sol {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
            return o1[1]-o2[1];
        });

        for (int i : map.keySet()){
            if (pq.size()<k){
                pq.add(new int[]{i, map.get(i)});
            }else if (pq.peek()[1]<map.get(i)){
                pq.poll();
                pq.add(new int[]{i, map.get(i)});
            }
        }

        int[] res = new int[k];
        for (int i=0; i<k; i++){
            res[i] = pq.poll()[0];
        }
        return res;

    }
}
