package com.leetcode2025;

import java.util.HashMap;
import java.util.Map;

public class LeeCo560Sol {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int numSum = 0;
        map.put(0, 1);
        for (int i : nums){
            numSum += i;
            if (map.containsKey(numSum-k)) res += map.get(numSum-k);
            map.put(numSum, map.getOrDefault(numSum, 0)+1);
        }
        return res;
    }
}
