package com.leetcode;

public class LeeCo226Sol {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);
        root.left = r;
        root.right = l;
        return root;
    }
}
