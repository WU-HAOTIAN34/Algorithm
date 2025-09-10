package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCo224Sol {

    public int calculate(String s) {
        Deque<String> dq = new ArrayDeque<>();
        int now = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c>='0' && c<='9'){
                now = now*10+Integer.parseInt(c+"");
                continue;
            }else if (c==')'){
                dq.add(now+"");
                Deque<String> tmp = new ArrayDeque<>();
                while (!dq.isEmpty() && !dq.peekLast().equals("(")) tmp.add(dq.pollLast());
                dq.pollLast();
                now = Integer.parseInt(tmp.pollLast());
                while (!tmp.isEmpty()){
                    if (tmp.peekLast().equals("+")){
                        tmp.pollLast();
                        now += Integer.parseInt(tmp.pollLast());
                    }else{
                        tmp.pollLast();
                        now -= Integer.parseInt(tmp.pollLast());
                    }
                }
            }else if (c=='+' || c=='-'){
                dq.add(now+"");
                dq.add(c+"");
                now = 0;
            }else if (c=='('){
                dq.add("(");
            }
        }
        dq.add(now+"");
        Deque<String> tmp = new ArrayDeque<>();
        while (!dq.isEmpty()) tmp.add(dq.pollLast());
        int num = Integer.parseInt(tmp.pollLast());
        while (!tmp.isEmpty()){
            if (tmp.peekLast().equals("+")){
                tmp.pollLast();
                num += Integer.parseInt(tmp.pollLast());
            }else{
                tmp.pollLast();
                num -= Integer.parseInt(tmp.pollLast());
            }
        }
        return num;
    }
}
