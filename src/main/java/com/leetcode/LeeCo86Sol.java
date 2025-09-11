package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeeCo86Sol {
    public ListNode partition(ListNode head, int x) {
        Queue<ListNode> q1 = new LinkedList<>();
        Queue<ListNode> q2 = new LinkedList<>();
        ListNode res = new ListNode(0, head);
        ListNode tmp = res.next;
        while (tmp!=null){
            if (tmp.val<x){
                q1.add(tmp);
            }else{
                q2.add(tmp);
            }
            tmp=tmp.next;
        }
        tmp = res;
        while (!q1.isEmpty()){
            tmp.next = q1.poll();
            tmp = tmp.next;
        }
        while (!q2.isEmpty()){
            tmp.next = q2.poll();
            tmp=tmp.next;
        }
        tmp.next = null;
        return res.next;
    }
}
