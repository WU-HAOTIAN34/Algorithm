package com.leetcode2025;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;


public class Main {
    public static void main(String[] args) {

        LeeCo146Sol leeCo146Sol = new LeeCo146Sol();
        LeeCo146Sol.LRUCache lruCache = leeCo146Sol.get(2);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.get(1);
        map.remove(map.lastEntry().getKey());
        map.remove(map.firstEntry().getKey());
        map.put(4, 4);

    }
}