package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeeCo200Sol {
    public int numIslands(char[][] grid) {
        Queue<List<Integer>> q = new LinkedList<>();
        int res = 0;
        int[][] pos = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]=='1'){
                    res++;
                    q.add(Arrays.asList(i, j));
                    grid[i][j] = '0';
                    while (!q.isEmpty()){
                        List<Integer> tmp = q.poll();
                        for (int[] p : pos){
                            int a = p[0]+tmp.get(0);
                            int b = p[1]+tmp.get(1);
                            if (a>=0&&a<grid.length&&b>=0&&b<grid[0].length&&grid[a][b]=='1'){
                                q.add(Arrays.asList(a, b));
                                grid[a][b] = '0';
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
