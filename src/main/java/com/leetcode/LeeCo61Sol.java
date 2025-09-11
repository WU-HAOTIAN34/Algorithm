package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCo61Sol {

    public ListNode rotateRight(ListNode head, int k) {
        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode res = new ListNode(0, head);
        ListNode tmp = res.next;
        int num = 0;
        while (tmp!=null){
            dq.add(tmp);
            tmp = tmp.next;
            num++;
        }
        if (num==0) return null;
        tmp = head;
        k%=num;
        while (k>0){
            ListNode l = tmp;
            tmp = dq.pollLast();
            tmp.next = l;
            k--;
        }
        res.next = tmp;
        dq.pollLast().next = null;
        return res.next;
    }
}
