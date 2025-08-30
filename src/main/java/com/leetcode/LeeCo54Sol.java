package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeeCo54Sol {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = Math.min(matrix.length, matrix[0].length)/2;

        for (int k=0; k<n; k++){
            for (int i=k; i<matrix[0].length-1-k; i++) res.add(matrix[k][i]);
            for (int i=k; i<matrix.length-1-k; i++) res.add(matrix[i][matrix[0].length-1-k]);
            for (int i=matrix[0].length-1-k; i>k; i--) res.add(matrix[matrix.length-1-k][i]);
            for (int i=matrix.length-1-k; i>k; i--) res.add(matrix[i][k]);
        }

        if (Math.min(matrix.length, matrix[0].length)%2==1){
            if (matrix.length <= matrix[0].length){
                for (int i=n; i<matrix[0].length-n; i++) res.add(matrix[n][i]);
            }else{
                for (int i=n; i<matrix.length-n; i++) res.add(matrix[i][n]);
            }
        }
        return res;
    }
}
