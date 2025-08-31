package com.leetcode;

import java.util.List;
import java.util.*;

public class LeeCo207Sol {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int[] i : prerequisites){
            if (!map.containsKey(i[0])){
                map.put(i[0], new int[numCourses+1]);
            }
            map.get(i[0])[i[1]]++;
            map.get(i[0])[numCourses]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<numCourses; i++){
            if (!map.containsKey(i)){
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int i = q.poll();
            for (int j : map.keySet()){
                int[] tmp = map.get(j);
                if (tmp[i]==1){
                    tmp[i]--;
                    tmp[numCourses]--;
                    if (tmp[numCourses]==0){
                        q.add(j);
                    }
                }
            }
        }

        for (int i : map.keySet()){
            if (map.get(i)[numCourses]!=0){
                return false;
            }
        }
        return true;
    }
}
