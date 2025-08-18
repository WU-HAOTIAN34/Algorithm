package com.leetcode2025;

public class LeeCo98Sol {

    public boolean isValidBST(TreeNode root) {
        return travel(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean travel(TreeNode root, long l, long r){
        if (root==null){
            return true;
        }
        if (root.val>l && root.val<r){
            return travel(root.left, l, root.val) && travel(root.right, root.val, r);

        }else{
            return false;
        }
    }
}
