package com.leetcode;

public class LeeCo82Sol {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode tmp = res;
        int[] map = new int[201];
        while (tmp.next!=null){
            map[tmp.next.val+100]++;
            tmp = tmp.next;
        }
        tmp = res;
        while (tmp.next!=null){
            if (map[tmp.next.val+100]>1){
                int num = map[tmp.next.val+100];
                ListNode l = tmp;
                while (num>0){
                    l = l.next;
                    num--;
                }
                tmp.next = l.next;
            }else{
                tmp = tmp.next;
            }
        }
        return res.next;
    }
}
