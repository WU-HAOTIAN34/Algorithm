package com.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyConcurrentMap<K, V> {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Node[] arr = new Node[16];
    private int num = 0;
    private int capacity;
    private int factor;

    class Node<K, V>{
        K key;
        V value;
        Node<K, V> next;
        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public void put(K key, V value){
        lock.lock();
        try{
            int hashCode = key.hashCode()%arr.length;
            if (arr[hashCode] == null){
                arr[hashCode] = new Node<>(key, value, null);
            }else{
                Node head = arr[hashCode];
                Boolean exit = false;
                do{
                    if (head.key.equals(key)){
                        exit = true;
                        head.value = value;
                        break;
                    }
                    head = head.next;
                }while (head.next != null);
            }
        }finally {
            lock.unlock();
        }
    }

}
