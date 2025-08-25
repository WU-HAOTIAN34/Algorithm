package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCo234Sol {

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> dq = new ArrayDeque<>();
        while (head!=null){
            dq.addLast(head.val);
            head = head.next;
        }
        while (dq.size()>1){
            if (dq.pollLast()!=dq.pollFirst()) return false;
        }
        return true;
    }
}
