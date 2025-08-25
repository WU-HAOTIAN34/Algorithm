package com.leetcode;

public class LeeCo160Sol {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int[] b = new int[2];
        while (p1!=p2 && !(b[0]>1 && b[1]>1)){
            p1 = p1.next;
            if (p1==null){
                p1 = headB;
                b[0]++;
            }
            p2 = p2.next;
            if (p2==null){
                p2 = headA;
                b[1]++;
            }
        }
        return p1==p2? p1 : null;
    }
}
