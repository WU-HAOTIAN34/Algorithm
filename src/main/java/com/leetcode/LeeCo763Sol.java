package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeeCo763Sol {

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        int maxP = 0;
        int len = 0;
        for (int i=0; i<s.length(); i++){
            maxP = Math.max(maxP, map.get(s.charAt(i)));
            if (i==maxP){
                res.add(i+1-len);
                len += i+1-len;
                maxP++;
            }
        }
        return res;
    }
}
