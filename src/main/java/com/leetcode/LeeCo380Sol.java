package com.leetcode;

import java.util.*;

public class LeeCo380Sol {

    public RandomizedSet randomizedSet = new RandomizedSet();

    class RandomizedSet {

        Map<Integer, Integer> map;
        List<Integer> l;

        public RandomizedSet() {
            map = new HashMap<>();
            l = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)){
                return false;
            }
            l.add(val);
            map.put(val, l.size()-1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)){
                return false;
            }
            int pos = map.get(val);
            int tmp = l.get(l.size()-1);
            l.set(pos, tmp);
            map.put(tmp, pos);
            map.remove(val);
            l.remove(l.size()-1);
            return true;
        }

        public int getRandom() {
            int num = (int)(Math.random()*map.size());
            return l.get(num);
        }
    }
}
