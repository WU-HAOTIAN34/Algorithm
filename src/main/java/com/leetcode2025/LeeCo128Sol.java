package com.leetcode2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeeCo128Sol {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i : nums) set.add(i);
        for (int i : set){
            if (!set.contains(i-1)){
                int num = 0;
                while (set.contains(i)){
                    num++;
                    i++;
                }
                res = Math.max(res, num);
            }
        }
        return res;
    }
}
