package com.leetcode2025;


import java.util.HashMap;
import java.util.Map;




public class LeeCo138Sol {

    public Node copyRandomList(Node head) {
        Node res = new Node(0);
        Node tmp = res;
        Map<Node, Node> map = new HashMap<>();
        while (head!=null){
            tmp.next = new Node(head.val);
            map.put(head, tmp.next);
            tmp = tmp.next;
            head = head.next;
        }
        for (Node n : map.keySet()){
            Node tar = map.get(n);
            if (n.random != null) tar.random = map.get(n.random);
        }
        return res.next;
    }
}
