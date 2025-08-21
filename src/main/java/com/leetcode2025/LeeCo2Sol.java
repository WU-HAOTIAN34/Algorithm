package com.leetcode2025;

public class LeeCo2Sol {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return travel(l1, l2, 0);
    }

    private ListNode travel(ListNode l1, ListNode l2, int i){
        if (l1==null && l2==null){
            if (i==0){
                return null;
            }else{
                return new ListNode(1);
            }
        }
        if (l1!=null && l2!=null){
            int n = l1.val+l2.val+i;
            return new ListNode(n%10, travel(l1.next, l2.next, n/10));
        }else if (l1==null){
            int n = l2.val+i;
            return new ListNode(n%10, travel(null, l2.next, n/10));
        }else{
            int n = l1.val+i;
            return new ListNode(n%10, travel(l1.next, null, n/10));
        }
    }
}
