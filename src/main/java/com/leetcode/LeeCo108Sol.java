package com.leetcode;

public class LeeCo108Sol {

    public TreeNode sortedArrayToBST(int[] nums) {
        return travel(nums, 0, nums.length);
    }

    public TreeNode travel(int[] nums, int l, int r){
        if (l>=r) return null;
        int middle = (l+r) / 2;
        return new TreeNode (nums[middle], travel(nums, l, middle), travel(nums, middle+1, r));
    }
}
