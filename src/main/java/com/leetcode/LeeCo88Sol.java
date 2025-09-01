package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeeCo88Sol {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = 0;
        int p1 = 0;
        int p2 = 0;
        Queue<Integer> q = new LinkedList<>();
        while (pos < m + n) {
            while (p1 <= pos || q.isEmpty()) {
                if (p1 == m && p2 == n) break;
                if (p1 < m && p2 < n) {
                    if (nums1[p1] <= nums2[p2]) {
                        q.add(nums1[p1]);
                        p1++;
                    } else {
                        q.add(nums2[p2]);
                        p2++;
                    }
                } else if (p1 == m) {
                    q.add(nums2[p2]);
                    p2++;
                } else {
                    q.add(nums1[p1]);
                    p1++;
                }
            }
            nums1[pos] = q.poll();
            pos++;
        }
    }
}
