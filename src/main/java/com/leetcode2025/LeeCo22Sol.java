package com.leetcode2025;

import java.util.ArrayList;
import java.util.List;

public class LeeCo22Sol {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n==0){
            return res;
        }
        backtracking(new StringBuilder(), n, n, n);
        return res;
    }

    public void backtracking(StringBuilder sb, int l, int r, int n){
        if (sb.length()==n*2){
            res.add(sb.toString());
        }else{
            if (l>0){
                sb.append("(");
                backtracking(sb, l-1, r, n);
                sb.deleteCharAt(sb.length()-1);
            }
            if (r>0 && l<r){
                sb.append(")");
                backtracking(sb, l, r-1, n);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
