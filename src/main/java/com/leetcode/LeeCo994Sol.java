package com.leetcode;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeeCo994Sol {

    public int orangesRotting(int[][] grid) {
        int res = Integer.MAX_VALUE;
        int n = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]==1){
                    grid[i][j] = Integer.MAX_VALUE;
                    n++;
                }else if (grid[i][j]==2){
                    grid[i][j] = 1;
                }
            }
        }
        if (n==0) return 0;
        int[][] pos = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]==1){
                    int day = 2;
                    int num = 1;
                    int next = 0;
                    Queue<List<Integer>> q = new LinkedList<>();
                    q.add(Arrays.asList(i, j));
                    while (!q.isEmpty()){

                        while (num>0){
                            List<Integer> l = q.poll();
                            num--;
                            grid[l.get(0)][l.get(1)] = day-1;
                            for (int[] p :pos){
                                int a = p[0]+l.get(0);
                                int b = p[1]+l.get(1);
                                if (a>=0&&a<grid.length&&b>=0&&b<grid[0].length&&grid[a][b]>day){
                                    q.add(Arrays.asList(a, b));
                                    next++;
                                }
                            }
                        }
                        num = next;
                        next = 0;
                        day++;
                    }
                    res = Math.min(res, day);
                }
            }
        }
        res = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]==Integer.MAX_VALUE){
                    return -1;
                }
                res = Math.max(res, grid[i][j]);
            }
        }
        return res-1;
    }


}
