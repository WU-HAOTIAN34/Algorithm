package com.leetcode2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeeCo118Sol {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for (int i=1; i<numRows; i++){
            List<Integer> now = new ArrayList<>();
            now.add(1);
            for (int j=0; j<i-1; j++){
                now.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
            }
            now.add(1);
            res.add(now);
        }
        return res;
    }
}
