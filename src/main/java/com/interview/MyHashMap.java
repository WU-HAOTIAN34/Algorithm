package com.interview;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private static final float LOAD_FACTOR = 0.75f;

    private static List<Integer> l = new LinkedList<>();


    private LinkedList<Node<K, V>>[] buckets;
    private int size = 0;


    private static class Node<K, V> {
        K key;
        V value;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }


    public MyHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];

    }


    private int hash(K key) {
        return (key == null) ? 0 : key.hashCode() & 0x7fffffff;
    }


    private int indexFor(K key) {
        return hash(key) % buckets.length;
    }


    public void put(K key, V value) {
        int index = indexFor(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Node<K, V> node : buckets[index]) {
            if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                node.value = value;
                return;
            }
        }
        buckets[index].add(new Node<>(key, value));
        size++;


        if (size >= buckets.length * LOAD_FACTOR) {
            resize();
        }
    }


    public V get(K key) {
        int index = indexFor(key);
        LinkedList<Node<K, V>> bucket = buckets[index];
        if (bucket == null) return null;
        for (Node<K, V> node : bucket) {
            if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                return node.value;
            }
        }
        return null;
    }


    private void resize() {
        LinkedList<Node<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;

        for (LinkedList<Node<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Node<K, V> node : bucket) {
                    put(node.key, node.value);
                }
            }
        }
    }


    public int size() {
        return size;
    }


    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);
        map.put("banana", 5);

        System.out.println("apple -> " + map.get("apple"));
        System.out.println("banana -> " + map.get("banana"));
        System.out.println("orange -> " + map.get("orange"));
        System.out.println("size = " + map.size());
    }
}
