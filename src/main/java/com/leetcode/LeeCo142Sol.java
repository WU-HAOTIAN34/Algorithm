package com.leetcode;

public class LeeCo142Sol {

    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        do{
            p1 = p1.next;
            p2 = p2.next;
            if (p2==null) return null;
            p2 = p2.next;
            if (p2==null) return null;
        } while (p1!=p2);
        p2 = head;

        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
