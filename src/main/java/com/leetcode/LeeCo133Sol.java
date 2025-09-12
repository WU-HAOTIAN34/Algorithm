package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeeCo133Sol {

    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node==null) return null;
        Node res = new Node(node.val, new ArrayList<>());
        map.put(node.val, res);
        for (Node n : node.neighbors){
            if (map.containsKey(n.val)){
                res.neighbors.add(map.get(n.val));
            }else{
                res.neighbors.add(cloneGraph(n));
            }
        }
        return res;
    }

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


}
