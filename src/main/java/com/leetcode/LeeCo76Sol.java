package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeeCo76Sol {

    public String minWindow(String s, String t) {
        Map<Character, Integer> tar = new HashMap<>();
        int len = 0;
        int l = 0;
        String res = s+s;
        for (char c : t.toCharArray()) tar.put(c, tar.getOrDefault(c, 0)+1);
        for (int r=0; r<s.length(); r++){
            char c = s.charAt(r);
            if (len==0 && !tar.containsKey(c)){
                l = r+1;
                continue;
            }

            if (tar.containsKey(c)){
                if (tar.get(c)>0){
                    len++;
                    tar.put(c, tar.get(c)-1);
                }else{
                    while (s.charAt(l)!=c){
                        if (tar.containsKey(s.charAt(l))){
                            tar.put(s.charAt(l), tar.get(s.charAt(l))+1);
                            len--;
                        }
                        l++;
                    }
                    l++;
                    while (!tar.containsKey(s.charAt(l))) l++;
                }
            }
            if (len==t.length()) res = res.length()>r-l+1 ? s.substring(l,r+1) : res;
        }
        return res.length()>s.length()?"":res;
    }
}
