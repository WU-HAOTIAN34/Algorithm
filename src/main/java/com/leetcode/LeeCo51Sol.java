package com.leetcode;
import java.util.ArrayList;
import java.util.List;
public class LeeCo51Sol {

    List<List<String>> res = new ArrayList<>();
    List<Integer> l = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        backtracking(0, n);
        return res;
    }

    public void backtracking(int pos, int n){
        if (l.size()==n){
            res.add(getRes());
        }else{
            for (int i=0; i<n; i++){
                l.add(i);
                if (judge(pos, n)){
                    backtracking(pos+1, n);
                }
                l.removeLast();
            }
        }
    }


    public boolean judge(int pos, int n){
        for (int i=pos-1; i>=0; i--){
            int dis = pos-i;
            int left = l.get(pos)-dis;
            int right = l.get(pos)+dis;
            int temp = l.get(i);
            if (temp==l.get(pos) || temp==left || temp==right){
                return false;
            }
        }

        return true;
    }


    public List<String> getRes(){
        List<String> result = new ArrayList<>();
        for (int i=0; i<l.size(); i++){
            String s = "";
            for (int j=0; j<l.size(); j++){
                if (j==l.get(i)){
                    s += "Q";
                }else{
                    s += ".";
                }
            }
            result.add(s);
        }
        return result;
    }
}
