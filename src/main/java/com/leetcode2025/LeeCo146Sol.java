package com.leetcode2025;

import java.util.LinkedHashMap;

public class LeeCo146Sol {


    public LRUCache get(int capacity) {
        return new LRUCache(capacity);
    }

    class LRUCache {

        LinkedHashMap<Integer, Integer> map;
        int num;

        public LRUCache(int capacity) {
            num = capacity;
            map = new LinkedHashMap<>(capacity, 0.75f, true);
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            if (!map.containsKey(key) && map.size()==num){
                map.remove(map.firstEntry().getKey());
            }
            map.put(key, value);
        }
    }
}
