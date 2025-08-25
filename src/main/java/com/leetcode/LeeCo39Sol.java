package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeeCo39Sol {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> now = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, 0, target, 0);
        return res;
    }

    public void backtracking(int[] c, int pos, int t, int num){
        if (num==t){
            res.add(new ArrayList<>(now));
        }else if (num<t){
            for (int i=pos; i<c.length; i++){
                now.add(c[i]);
                backtracking(c, i, t, num+c[i]);
                now.removeLast();
            }
        }
    }
}
