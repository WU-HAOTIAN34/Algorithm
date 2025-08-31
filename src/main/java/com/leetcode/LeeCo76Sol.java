package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeeCo76Sol {

    public String minWindow(String s, String t) {
        int[] tar = new int[100];
        int[] now = new int[100];
        int len = 0;
        int l = 0;
        String res = s+s;
        for (char c : t.toCharArray()) tar[c-'A']++;
        for (int r=0; r<s.length(); r++){
            char c = s.charAt(r);
            if (tar[c-'A']>0){
                if (now[c-'A']<tar[c-'A']){
                    len++;
                }
                now[c-'A']++;
            }
            while (l<=r && (now[s.charAt(l)-'A']>tar[s.charAt(l)-'A'] || tar[s.charAt(l)-'A']==0)){
                if (tar[s.charAt(l)-'A']>0){
                    now[s.charAt(l)-'A']--;
                }
                l++;
            }
            if (len==t.length()){
                res = res.length()>r-l+1?s.substring(l,r+1):res;
            }
        }
        return res.length()>s.length()?"":res;
    }
}
