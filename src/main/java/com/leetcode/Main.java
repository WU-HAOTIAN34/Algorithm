package com.leetcode;

import java.util.*;


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