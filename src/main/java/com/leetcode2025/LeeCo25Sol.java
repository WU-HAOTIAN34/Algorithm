package com.leetcode2025;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCo25Sol {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l = head;
        int n = k;
        Deque<ListNode> dq = new ArrayDeque<>();
        while(n>0){
            if (l==null) return head;
            n--;
            dq.addLast(l);
            l = l.next;
        }
        ListNode res = new ListNode(0);
        head = res;
        while (!dq.isEmpty()){
            head.next = dq.pollLast();
            head = head.next;
        }
        head.next = reverseKGroup(l, k);
        return res.next;
    }
}
