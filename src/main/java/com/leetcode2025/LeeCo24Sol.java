package com.leetcode2025;

public class LeeCo24Sol {

    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode n1 = res;
        while (n1.next != null){
            if (n1.next.next==null) break;
            ListNode tmp = n1.next.next.next;
            ListNode tmp2 = n1.next;
            n1.next = n1.next.next;
            n1 = n1.next;
            n1.next = tmp2;
            n1 = n1.next;
            n1.next = tmp;
        }
        return res.next;
    }
}
