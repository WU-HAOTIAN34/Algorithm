package com.leetcode2025;

import java.util.HashMap;
import java.util.Map;

public class LeeCo32Sol {

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put(')', -1);

        int res = 0;


        for (int i=0; i<s.length()-1; i++){
            dp[i] = map.get(s.charAt(i));
            for (int j=i+1; j<s.length(); j++){
                if (dp[j-1]<0 || dp[j-1]>(j-i+1)/2) break;
                // if (s.charAt(j)=='('){
                //     dp[j] = dp[j-1] + 1;
                // }else{
                //     dp[j] = dp[j-1] - 1;
                // }
                dp[j] = dp[j-1]+ map.get(s.charAt(j));
                if (dp[j] == 0) res = Math.max(res, j-i+1);
            }
        }

        return res;
    }
}
