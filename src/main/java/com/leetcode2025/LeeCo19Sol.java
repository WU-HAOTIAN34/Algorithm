package com.leetcode2025;

public class LeeCo19Sol {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode p1 = res;
        ListNode p2 = res;
        for (int i=0; i<n; i++){
            p1 = p1.next;
        }
        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return res.next;
    }
}
