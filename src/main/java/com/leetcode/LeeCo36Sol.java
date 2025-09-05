package com.leetcode;

public class LeeCo36Sol {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] win = new boolean[9][10];
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                char c = board[i][j];
                if (c=='.') continue;
                if (row[i][c-'0'] || col[j][c-'0'] || win[i/3*3+j/3][c-'0']) return false;
                row[i][c-'0'] = true;
                col[j][c-'0'] = true;
                win[i/3*3+j/3][c-'0'] = true;
            }
        }
        return true;
    }
}
