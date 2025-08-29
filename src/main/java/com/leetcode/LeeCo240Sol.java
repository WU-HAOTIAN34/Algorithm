package com.leetcode;

public class LeeCo240Sol {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = 0;
        for ( ; n<Math.min(matrix.length, matrix[0].length); n++){
            if (matrix[n][n]==target){
                return true;
            }else if(matrix[n][n]>target){
                break;
            }
        }

        for (int i=0; i<matrix.length; i++){
            int be = i<n ? n : 0;
            int end = i<n ? matrix[0].length : n;
            for (int j=be; j<end; j++){
                if (matrix[i][j]==target){
                    return true;
                }else if(matrix[i][j]>target){
                    break;
                }
            }

        }

        return false;

    }
}
