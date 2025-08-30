package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCo739Sol {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i=0; i<temperatures.length; i++){
            while (!dq.isEmpty() && temperatures[dq.peekLast()]<temperatures[i]){
                res[dq.peekLast()] = i - dq.pollLast();
            }
            dq.add(i);
        }
        return res;
    }
}
