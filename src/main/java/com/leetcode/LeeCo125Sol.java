package com.leetcode;

public class LeeCo125Sol {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for ( char c : s.toCharArray()){
            if ((c>='a' && c<='z') || (c>='0' && c<='9')) sb.append(c);
        }
        String a = sb.toString();
        return a.equals(sb.reverse().toString());
    }
}
