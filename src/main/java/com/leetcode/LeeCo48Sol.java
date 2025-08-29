package com.leetcode;

public class LeeCo48Sol {

    public void rotate(int[][] matrix) {
        for (int k=0; k<matrix.length/2; k++){
            for (int i=k; i<matrix.length-1-k; i++){
                int n = matrix[k][i];
                matrix[k][i] = matrix[matrix.length-1-i][k];
                matrix[matrix.length-1-i][k] = matrix[matrix.length-1-k][matrix.length-1-i];
                matrix[matrix.length-1-k][matrix.length-1-i] = matrix[i][matrix.length-1-k];
                matrix[i][matrix.length-1-k] = n;
            }
        }
    }
}
