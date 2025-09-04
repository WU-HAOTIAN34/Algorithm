package com.leetcode;

public class LeeCo58Sol {

    public int lengthOfLastWord(String s) {
        int res = 0;
        int i = s.length()-1;
        while (s.charAt(i)==' ') i--;
        for ( ; i>=0; i--){
            if (s.charAt(i)==' ') break;
            res++;
        }
        return res;
    }
}
