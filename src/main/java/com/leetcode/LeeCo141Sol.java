package com.leetcode;

public class LeeCo141Sol {

    public boolean hasCycle(ListNode head) {
        if (head==null) return false;
        ListNode p1 = head;
        ListNode p2 = head;
        do{
            p1 = p1.next;
            p2 = p2.next;
            if (p2==null) return false;
            p2 = p2.next;
            if (p2==null) return false;
        } while (p1!=p2);
        return true;

    }
}
