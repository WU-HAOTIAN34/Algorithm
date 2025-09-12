package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeeCo130Sol {

    public void solve(char[][] board) {
        boolean[][] map = new boolean[board.length][board[0].length];
        int[][] pos = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]=='O' && !map[i][j]){
                    Queue<List<Integer>> q = new LinkedList<>();
                    Queue<List<Integer>> q2 = new LinkedList<>();
                    boolean b = false;
                    q.add(Arrays.asList(i, j));
                    q2.add(Arrays.asList(i, j));
                    map[i][j] = true;
                    while (!q.isEmpty()){
                        List<Integer> l = q.poll();
                        for (int[] p : pos){
                            int x = l.get(0)+p[0];
                            int y = l.get(1)+p[1];
                            if (!(x>=0&&x<board.length&&y>=0&&y<board[0].length)){
                                b = true;
                            }else if (!map[x][y] && board[x][y]=='O'){
                                q.add(Arrays.asList(x, y));
                                q2.add(Arrays.asList(x, y));
                                map[x][y] = true;
                            }
                        }
                    }
                    if (!b){
                        while (!q2.isEmpty()){
                            List<Integer> l = q2.poll();
                            board[l.get(0)][l.get(1)] = 'X';
                        }
                    }
                }
            }
        }
    }
}
