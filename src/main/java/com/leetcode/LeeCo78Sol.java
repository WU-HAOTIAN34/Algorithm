package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeeCo78Sol {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> now = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] n, int pos){
        if(pos == n.length){
            res.add(new ArrayList<>(now));
        }else{
            now.add(n[pos]);
            backtracking(n, pos+1);
            now.removeLast();
            backtracking(n, pos+1);
        }
    }
}
