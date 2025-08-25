package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeeCo46Sol {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> now = new ArrayList<>();
    boolean[] b;

    public List<List<Integer>> permute(int[] nums) {
        b = new boolean[nums.length];
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] n){
        if (now.size()==n.length){
            res.add(new ArrayList<>(now));
        }else{
            for (int i=0; i<n.length; i++){
                if (!b[i]){
                    now.add(n[i]);
                    b[i] = true;
                    backtracking(n);
                    now.removeLast();
                    b[i] = false;
                }
            }
        }
    }
}
