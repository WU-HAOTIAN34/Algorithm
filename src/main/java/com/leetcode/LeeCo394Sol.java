package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCo394Sol {

    public String decodeString(String s) {
        Deque<String> dq = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c==']'){
                StringBuilder sb = new StringBuilder();
                while (!dq.peekLast().equals("[")) sb.insert(0, dq.pollLast());
                dq.pollLast();
                int n = Integer.parseInt(dq.pollLast());
                String res = "";
                while (n>0){
                    res+=sb.toString();
                    n--;
                }
                dq.addLast(res);
            }else if (c>='0' && c<='9'){
                String res = "";
                while (!(s.charAt(i)=='[')){
                    res += s.charAt(i);
                    i++;
                }
                i--;
                dq.addLast(res);
            }else{
                dq.addLast(c+"");
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) sb.append(dq.pollFirst());
        return sb.toString();
    }
}
