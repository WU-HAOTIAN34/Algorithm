package com.kamacoder;

import java.util.*;

public class KaMa284Sol {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int res = 0;
        Deque<Character> dq = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c==')'){
                if (dq.isEmpty()){
                    break;
                }else if (dq.peekLast()=='('){
                    dq.pollLast();
                }else{
                    dq.add(c);
                }
            }else{
                dq.add(c);
            }
            if (dq.isEmpty()) res = i+1;
        }

        System.out.println(res);
    }
}
