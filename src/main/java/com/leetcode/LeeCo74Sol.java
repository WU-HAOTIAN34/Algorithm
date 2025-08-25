package com.leetcode;

public class LeeCo74Sol {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length*matrix[0].length-1;
        int len = matrix[0].length;
        while (l<=r){
            int m = (l+r)/2;
            if (matrix[m/len][m%len]==target){
                return true;
            }else if (matrix[m/len][m%len]<target){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return false;
    }
}
