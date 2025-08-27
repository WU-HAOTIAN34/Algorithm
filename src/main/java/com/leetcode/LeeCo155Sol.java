package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeeCo155Sol {

    MinStack minStack = new MinStack();

    class MinStack {

        List<Integer> list;
        Deque<Integer> dq;

        public MinStack() {
            this.list = new ArrayList<>();
            this.dq = new ArrayDeque<>();
        }

        public void push(int val) {
            list.add(val);
            if (dq.isEmpty() || dq.peekLast()>=val){
                dq.addLast(val);
            }
        }

        public void pop() {
            int val = list.get(list.size()-1);
            if (val == dq.peekLast()) dq.pollLast();
            list.remove(list.size()-1);
        }

        public int top() {
            return list.get(list.size()-1);
        }

        public int getMin() {
            return dq.peekLast();
        }
    }
}
