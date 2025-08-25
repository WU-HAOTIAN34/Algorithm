package com.leetcode;

public class LeeCo230Sol {

    int num = 0;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        travel(root, k);
        return res;
    }


    private void travel(TreeNode root, int k){
        if (num==k) return;
        if (root.left != null) travel(root.left, k);
        num++;
        if (num==k) res = root.val;
        if (root.right != null) travel(root.right, k);
    }
}
