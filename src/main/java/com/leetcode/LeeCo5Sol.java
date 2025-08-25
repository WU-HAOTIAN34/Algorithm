package com.leetcode;

public class LeeCo5Sol {

    public String longestPalindrome(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = s.charAt(0)+"";

        dp[0][0] = true;
        for (int i=1; i<s.length(); i++){
            dp[i][i] = true;
            dp[i][i-1] = true;
        }

        for (int i=s.length()-2; i>=0; i--){
            for (int j=i+1; j<s.length(); j++){
                if (s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if (j-i+1>res.length()){
                        res = s.substring(i, j+1);
                    }
                }
            }
        }

        return res;


    }
}
