package com.leetcode2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeeCo17Sol {

    Map<Character, List<Character>> map = new HashMap<>();
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
        }
        backtracking(digits, 0, new StringBuilder());
        return res;

    }

    public void backtracking(String digits, int pos, StringBuilder sb){
        if (pos==digits.length()){
            res.add(sb.toString());
        }else{
            List<Character> list = map.get(digits.charAt(pos));
            for (Character c : list){
                sb.append(c);
                backtracking(digits, pos+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
