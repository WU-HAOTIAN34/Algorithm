package com.leetcode;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        LeeCo148Sol leeCo148Sol = new LeeCo148Sol();
        leeCo148Sol.sortList(listNode);

    }
}