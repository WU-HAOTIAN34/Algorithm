package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCo71Sol {
    public String simplifyPath(String path) {

        Deque<String> dq = new ArrayDeque<>();
        for (int i=0; i<path.length(); i++){
            char c = path.charAt(i);
            if (c=='.'){
                String tmp = "";
                int num = 0;
                boolean b = false;
                while (i<path.length() && path.charAt(i)!='/'){
                    if (path.charAt(i)=='.') num++;
                    if (path.charAt(i)!='.' || num>2) b = true;

                    tmp+=path.charAt(i);
                    i++;
                }

                if (b){
                    dq.add("/"+tmp);
                }else if (num==2){
                    dq.pollLast();
                }
            }else if (c!='/'){
                String tmp = "";
                while (i<path.length() && path.charAt(i)!='/'){
                    tmp+=path.charAt(i);
                    i++;
                }

                dq.add("/"+tmp);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) sb.insert(0, dq.pollLast());
        if (sb.length()==0) sb.append("/");
        return sb.toString();
    }
}
