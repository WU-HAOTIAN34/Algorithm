package com.leetcode;

public class LeeCo124Sol {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        travel(root);
        return res;
    }


    public int travel(TreeNode root){
        int l = 0;
        int r = 0;
        if (root.left!=null) l = travel(root.left);
        if (root.right!=null) r = travel(root.right);
        int maxP = Math.max(l, r)+root.val;
        res = Math.max(res, maxP);
        res = Math.max(res, l+r+root.val);
        return Math.max(0, maxP);
    }
}
