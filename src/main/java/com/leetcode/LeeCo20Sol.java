package com.leetcode;
import java.util.*;
public class LeeCo20Sol {

    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char i : s.toCharArray()){
            if (!dq.isEmpty()&&((i==')' && dq.peekLast()=='(')||(i==']' && dq.peekLast()=='[')||(i=='}' && dq.peekLast()=='{'))){
                dq.pollLast();
            }else{
                dq.addLast(i);
            }
        }
        return dq.isEmpty();
    }
}
