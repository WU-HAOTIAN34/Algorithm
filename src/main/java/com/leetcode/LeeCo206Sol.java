package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeeCo206Sol {

    public ListNode reverseList(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque<>();
        while (head!=null){
            dq.addLast(head);
            head = head.next;
        }
        ListNode res = new ListNode(0);
        head = res;
        while (!dq.isEmpty()){
            head.next = dq.pollLast();
            head = head.next;
        }
        head.next = null;
        return res.next;
    }
}
