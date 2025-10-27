package com.interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    class Node<K, V>{
        K key;
        V value;
        Node pre;
        Node next;
        public Node(K k, V v){
            key = k;
            value = v;
        }
    }

    Map<K, Node<K, V>> map;
    Node<K, V> head;
    Node<K, V> tail;
    int capacity;

    public LRUCache(int c){
        capacity = c;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    void delete(Node n){
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }

    void add(Node n){
        n.pre = tail.pre;
        n.next = tail;
        tail.pre.next = n;
        tail.pre = n;
    }

    public void put(K key, V value){
        if (map.containsKey(key)){
            Node<K, V> n = map.get(key);
            delete(n);
            n.value = value;
            add(n);
        }else{
            if (map.size() == capacity){
                Node<K, V> n = head.next;
                delete(n);
                map.remove(n.key);
            }
            Node<K, V> n = new Node(key, value);
            map.put(key, n);
            add(n);
        }
    }

    public V get(K key){
        if (!map.containsKey(key)){
            return null;
        }else{
            Node<K, V> n = map.get(key);
            delete(n);
            add(n);
            return n.value;
        }
    }



}
