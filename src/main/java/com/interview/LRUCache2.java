package com.interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int k, int v){
            key = k;
            value = v;
        }
    }

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache2(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    void add(Node n){
        n.pre = tail.pre;
        n.next = tail;
        tail.pre.next = n;
        tail.pre = n;
    }

    void delete(Node n){
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }else{
            Node n = map.get(key);
            delete(n);
            add(n);
            return n.value;
        }
    }

    public void put(int key, int value){
        if (map.containsKey(key)){
            Node n = map.get(key);
            delete(n);
            n.value = value;
            add(n);
        }else{
            if (map.size() == capacity){
                Node n = head.next;
                delete(n);
                map.remove(n.key);
            }
            Node n = new Node(key, value);
            map.put(key, n);
            add(n);
        }
    }
}
