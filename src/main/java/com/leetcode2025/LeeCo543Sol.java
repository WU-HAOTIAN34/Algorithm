package com.leetcode2025;

public class LeeCo543Sol {

    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        travel(root);
        return res-1;

    }

    private int travel(TreeNode root){
        if (root==null) return 0;
        int a = travel(root.left);
        int b = travel(root.right);
        if (a+b+1>res){
            res = a+b+1;
        }
        return Math.max(a, b) + 1;
    }
}
