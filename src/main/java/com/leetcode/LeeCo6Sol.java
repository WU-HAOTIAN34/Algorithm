package com.leetcode;

import java.util.Arrays;

public class LeeCo6Sol {

    public String convert(String s, int numRows) {
        if (numRows==1) return s;
        int col = s.length();
        String[] cs = new String[numRows];
        Arrays.fill(cs, "");
        int[] pos = {0,0};
        for (int i=0; i<s.length(); i++){
            cs[pos[0]] += s.charAt(i);
            if (pos[1]%(numRows-1)==0){
                if (pos[0]!=(numRows-1)){
                    pos[0]++;
                }else{
                    pos[0]--;
                    pos[1]++;
                }
            }else{
                pos[0]--;
                pos[1]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str :cs) sb.append(str);
        return sb.toString();
    }
}
