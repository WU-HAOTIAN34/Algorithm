package com.leetcode;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        LeeCo240Sol leeCo240Sol = new LeeCo240Sol();
        int[][] nums = new int[][]{{-1, 3}};
        leeCo240Sol.searchMatrix(nums, 3);
        System.out.println(Arrays.toString(nums));

    }
}