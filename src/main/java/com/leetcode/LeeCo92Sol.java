package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCo92Sol {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(0, head);
        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode tmp = res;
        int i=0;
        for ( ; i<left-1; i++){
            tmp = tmp.next;
        }
        ListNode l = tmp;
        for ( ; i<right; i++){
            l = l.next;
            dq.add(l);
        }
        l = l.next;
        while (!dq.isEmpty()){
            tmp.next = dq.pollLast();
            tmp = tmp.next;
        }
        tmp.next = l;
        return res.next;
    }
}
