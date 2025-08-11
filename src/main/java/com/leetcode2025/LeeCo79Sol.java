package com.leetcode2025;

public class LeeCo79Sol {
    int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    boolean[][] bool;

    public boolean exist(char[][] board, String word) {
        boolean res = false;
        bool = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]==word.charAt(0)){
                    bool[i][j] = true;
                    res = backtracking(board, word, i, j, 1);
                    bool[i][j] = false;
                    if (res){
                        return res;
                    }
                }
            }
        }
        return false;
    }

    public boolean backtracking(char[][] ch, String w, int r, int c, int pos){
        if (pos == w.length()){
            return true;
        }else{
            boolean res = false;
            for (int i=0; i<4; i++){
                int a = r + dir[i][0];
                int b = c + dir[i][1];
                if (a>=0 && a<ch.length && b>=0 && b<ch[0].length && !bool[a][b] &&ch[a][b]==w.charAt(pos)){
                    bool[a][b] = true;
                    res = backtracking(ch,w,a,b,pos+1);
                    bool[a][b] = false;
                    if (res){
                        return res;
                    }
                }
            }
            return res;
        }
    }
}
