package com.leetcode2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeeCo17Sol {

    Map<Integer, List<Character>> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        int ch = 97;
        for (int i=2; i<10; i++){
            int num = 3;
            List<Character> list = new ArrayList<>();
            if (i==7 || i==9){
                num = 4;
            }
            while(num>0){
                list.add((char)ch);
                ch++;
                num--;
            }
            map.put(i, list);
        }
        if (digits.length()==0){
            return res;
        }
        backtracking(digits, 0, new StringBuilder());
        return res;

    }

    public void backtracking(String digits, int pos, StringBuilder sb){
        if (pos==digits.length()){
            res.add(sb.toString());
        }else{
            List<Character> list = map.get(Integer.parseInt(digits.substring(pos,pos+1)));
            for (Character c : list){
                sb.append(c);
                backtracking(digits, pos+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

}
