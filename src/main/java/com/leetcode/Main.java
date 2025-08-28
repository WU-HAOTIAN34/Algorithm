package com.leetcode;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        LeeCo283Sol leeCo283Sol = new LeeCo283Sol();
        int[] nums = new int[]{1,0,0};
        leeCo283Sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
}