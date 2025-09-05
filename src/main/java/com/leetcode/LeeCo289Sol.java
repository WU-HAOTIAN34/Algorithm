package com.leetcode;

public class LeeCo289Sol {

    public void gameOfLife(int[][] board) {
        int[][] next = new int[board.length][board[0].length];

        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                int live = 0;
                for (int m=-1; m<=1; m++){
                    for (int n=-1; n<=1; n++){
                        if (m==0 && n==0) continue;
                        int x = i+m;
                        int y = j+n;
                        if (x>=0&&x<board.length&&y>=0&&y<board[0].length&&board[x][y]==1){
                            live++;
                        }
                    }
                }
                next[i][j] = board[i][j];
                if (board[i][j] == 0 && live==3){
                    next[i][j]=1;
                }else if ((board[i][j] == 1 && live<2) || (board[i][j] == 1 && live>3)){
                    next[i][j]=0;
                }
            }
        }
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                board[i][j] = next[i][j];
            }
        }
    }
}
