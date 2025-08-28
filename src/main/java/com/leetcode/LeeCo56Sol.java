package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeeCo56Sol {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{return a[0]-b[0];});
        List<List<Integer>> l = new ArrayList<>();
        for (int i=0; i<intervals.length; i++){
            int[] be = intervals[i];
            while (i+1<intervals.length && intervals[i+1][0]<=be[1]){
                be[1] = Math.max(intervals[i+1][1], be[1]);
                i++;
            }
            l.add(Arrays.asList(be[0], be[1]));
        }
        int[][] res = new int[l.size()][2];
        for (int i=0; i<res.length; i++){
            res[i][0] = l.get(i).get(0);
            res[i][1] = l.get(i).get(1);
        }
        return res;
    }
}
