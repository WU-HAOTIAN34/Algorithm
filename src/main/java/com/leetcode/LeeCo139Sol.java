package com.leetcode;

import java.util.List;

public class LeeCo139Sol {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[][] dp = new boolean[s.length()+1][wordDict.size()+1];

        for (int i=0; i<=wordDict.size(); i++){
            dp[0][i] = true;
        }
        
        for (int i=1; i<=s.length(); i++){
            for (int j=1; j<=wordDict.size(); j++){
                int len = wordDict.get(j-1).length();
                dp[i][j] = dp[i][j-1];
                if (i>=len){
                    dp[i][j] = dp[i][j] || (dp[i-len][wordDict.size()] && s.substring(i-len, i).equals(wordDict.get(j-1)));
                }
            }
        }

        return dp[s.length()][wordDict.size()];
    }
}
