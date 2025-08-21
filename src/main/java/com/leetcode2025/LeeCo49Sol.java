package com.leetcode2025;

import java.util.*;

public class LeeCo49Sol {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String keyStr = Arrays.toString(tmp);
            if (!map.containsKey(keyStr)){
                List<String> l = new ArrayList<>();
                map.put(keyStr, l);
            }
            map.get(keyStr).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (String s : map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
}
