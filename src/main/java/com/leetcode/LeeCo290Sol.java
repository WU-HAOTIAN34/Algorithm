package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeeCo290Sol {

    public boolean wordPattern(String pattern, String s) {

        String[] w = s.split(" ");
        if (pattern.length() != w.length) return false;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            if (map.containsKey(c)){
                if (!map.get(c).equals(w[i])){
                    return false;
                }
            }else{
                map.put(c, w[i]);
            }
            if (map2.containsKey(w[i])){
                if (!map2.get(w[i]).equals(c)){
                    return false;
                }
            }else{
                map2.put(w[i], c);
            }
        }
        return true;
    }
}
