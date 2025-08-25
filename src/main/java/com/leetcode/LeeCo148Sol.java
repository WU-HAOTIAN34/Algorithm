package com.leetcode;

public class LeeCo148Sol {

    public ListNode sortList(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode tmp = res;
        int num = 0;
        while (tmp.next!=null){
            tmp = tmp.next;
            num++;
        }
        for (int i=0; i<num-1; i++){
            tmp = res;
            for (int j=0; j<num-i-1; j++){
                ListNode a = tmp.next;
                if (a.val>a.next.val){
                    tmp.next = a.next;
                    tmp = tmp.next;
                    a.next = tmp.next;
                    tmp.next = a;
                }
            }
        }
        return res.next;
    }
}
