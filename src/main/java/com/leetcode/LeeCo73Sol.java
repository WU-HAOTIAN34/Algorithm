package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeeCo73Sol {

    public void setZeroes(int[][] matrix) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> row =  new HashSet<>();

        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j]==0){
                    col.add(i);
                    row.add(j);
                }
            }
        }
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (col.contains(i) || row.contains(j)) matrix[i][j] = 0;
            }
        }

    }
}
