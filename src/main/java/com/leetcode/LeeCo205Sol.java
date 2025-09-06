package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeeCo205Sol {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                if (t.charAt(i)!=map.get(s.charAt(i))){
                    return false;
                }
            }else{
                map.put(s.charAt(i), t.charAt(i));
            }
            if (map2.containsKey(t.charAt(i))){
                if (s.charAt(i)!=map2.get(t.charAt(i))){
                    return false;
                }
            }else{
                map2.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
