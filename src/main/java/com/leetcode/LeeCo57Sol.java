package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeeCo57Sol {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int p = 0;
        List<int[]> res = new ArrayList<>();
        while (p<intervals.length && intervals[p][1]<newInterval[0]){
            res.add(intervals[p]);
            p++;
        }
        while (p<intervals.length && intervals[p][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[p][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[p][1]);
            p++;
        }
        res.add(newInterval);
        while (p<intervals.length){
            res.add(intervals[p]);
            p++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}
