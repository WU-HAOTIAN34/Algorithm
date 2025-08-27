package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCo84Sol {

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] aft = new int[heights.length];
        int[] bef = new int[heights.length];
        int res = 0;
        for (int i=0; i<heights.length; i++){
            aft[i] = heights.length-1;
            while (!dq.isEmpty() && heights[dq.peekLast()]>heights[i]){
                aft[dq.pollLast()] = i-1;
            }
            dq.addLast(i);
        }
        dq = new ArrayDeque<>();
        for (int i=heights.length-1; i>=0; i--){
            while (!dq.isEmpty() && heights[dq.peekLast()]>heights[i]){
                bef[dq.pollLast()] = i+1;
            }
            dq.addLast(i);
        }
        for (int i=0; i<heights.length; i++){
            res = Math.max((aft[i]-bef[i]+1)*heights[i], res);
        }
        return res;

    }
}
