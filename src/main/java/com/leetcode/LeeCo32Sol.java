package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCo32Sol {


    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        stack.addLast(-1);

        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='('){
                stack.addLast(i);
            }else{
                stack.pollLast();
                if (stack.isEmpty()){
                    stack.addLast(i);
                }else{
                    res = Math.max(res, i-stack.peekLast());
                }
            }
        }

        return res;
    }


//    public int longestValidParentheses(String s) {
//        int[] dp = new int[s.length()];
//        Map<Character, Integer> map = new HashMap<>();
//        map.put('(', 1);
//        map.put(')', -1);
//
//        int res = 0;
//
//
//        for (int i=0; i<s.length()-1; i++){
//            dp[i] = map.get(s.charAt(i));
//            for (int j=i+1; j<s.length(); j++){
//                if (dp[j-1]<0 || dp[j-1]>(j-i+1)/2) break;
//                dp[j] = dp[j-1]+ map.get(s.charAt(j));
//                if (dp[j] == 0) res = Math.max(res, j-i+1);
//            }
//        }
//
//        return res;
//    }



}
