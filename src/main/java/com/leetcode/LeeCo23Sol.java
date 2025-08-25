package com.leetcode;

public class LeeCo23Sol {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;
        int num = (int) Math.ceil(Math.log(lists.length)/Math.log(2.0));
        int l = 0;
        int r = lists.length-1;
        for (int i=0; i<num; i++){
            while (l<r){
                lists[l] = merge(lists[l], lists[r]);
                l++;
                r--;
            }
            l = 0;
        }
        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2){
        if (l1==null && l2==null) return null;
        if (l1 != null && l2!=null){
            ListNode res = null;
            if (l1.val<l2.val){
                res = l1;
                res.next = merge(l1.next, l2);
            }else{
                res = l2;
                res.next = merge(l1, l2.next);
            }
            return res;
        }else if(l1==null){
            return l2;
        }else{
            return l1;
        }
    }
}
