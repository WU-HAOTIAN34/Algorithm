package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeeCo3Sol {

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int res = 0;
        while (r<s.length()){
            while (r<s.length() && !set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
            }
            res = Math.max(res, r-l);
            if (r>=s.length()) break;
            do {
                set.remove(s.charAt(l));
                l++;
            } while (s.charAt(l-1)!=s.charAt(r));
        }
        return res;
    }
}
