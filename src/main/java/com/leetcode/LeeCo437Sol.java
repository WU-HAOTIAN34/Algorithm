package com.leetcode;

public class LeeCo437Sol {

    public int pathSum(TreeNode root, int targetSum) {
        if (root==null) return 0;
        return travel(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int travel(TreeNode root, long t){
        if (root==null) return 0;
        int res = 0;
        if (root.val==t) res++;
        return travel(root.left, t-root.val) + travel(root.right, t-root.val) + res;
    }
}
