package com.leetcode;

public class LeeCo148Sol {

    public ListNode sortList(ListNode head) {
        if (head==null) return null;
        ListNode tmp = head;
        int num = 0;
        while (tmp!=null){
            tmp = tmp.next;
            num++;
        }
        return merge(head, num);
    }

    private ListNode merge(ListNode l, int num){
        if (num<=1) return l;
        ListNode l1 = l;
        ListNode l2 = l;
        for (int i=0; i<num/2-1; i++) l2 = l2.next;
        ListNode tmp = l2;
        l2 = merge(l2.next, num-num/2);
        tmp.next = null;
        l1 = merge(l1, num/2);

        ListNode res = new ListNode(0);
        l = res;
        while (true){
            if (l1==null && l2==null) break;
            if (l1!=null && l2!=null){
                if (l1.val<l2.val){
                    l.next = l1;
                    l1 = l1.next;
                }else{
                    l.next = l2;
                    l2 = l2.next;
                }
                l = l.next;
            }else{
                l.next = l1==null?l2:l1;
                break;
            }
        }
        return res.next;
    }

//    public ListNode sortList(ListNode head) {
//        ListNode res = new ListNode(0, head);
//        ListNode tmp = res;
//        int num = 0;
//        while (tmp.next!=null){
//            tmp = tmp.next;
//            num++;
//        }
//        for (int i=0; i<num-1; i++){
//            tmp = res;
//            for (int j=0; j<num-i-1; j++){
//                ListNode a = tmp.next;
//                if (a.val>a.next.val){
//                    tmp.next = a.next;
//                    tmp = tmp.next;
//                    a.next = tmp.next;
//                    tmp.next = a;
//                }
//            }
//        }
//        return res.next;
//    }
}
