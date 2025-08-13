package com.leetcode2025;

import java.util.ArrayList;
import java.util.List;

public class LeeCo131Sol {

    List<List<String>> res = new ArrayList<>();
    List<String> now = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int pos){
        if (s.length()==pos){
            res.add(new ArrayList<>(now));
        }else{
            for (int i=pos+1; i<=s.length(); i++){
                StringBuilder sb = new StringBuilder(s.substring(pos,i));
                String a = sb.toString();
                if (a.equals(sb.reverse().toString())){
                    now.add(a);
                    backtracking(s, i);
                    now.remove(now.size()-1);
                }
            }
        }
    }
}
