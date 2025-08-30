package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeeCo438Sol {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] tar = new int[26];
        int[] now = new int[26];
        for (char c : p.toCharArray()) tar[c-'a']++;
        int l = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (tar[c-'a']==0){
                l = i+1;
                now = new int[26];
                continue;
            }
            now[c-'a']++;
            if (now[c-'a']>tar[c-'a']){
                while (s.charAt(l)!=c){
                    now[s.charAt(l)-'a']--;
                    l++;
                }
                now[s.charAt(l)-'a']--;
                l++;
            }
            if (i-l+1==p.length()){
                res.add(l);
            }
        }
        return res;
    }
}
