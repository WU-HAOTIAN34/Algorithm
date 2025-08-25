package com.leetcode;

public class LeeCo101Sol {

    public boolean isSymmetric(TreeNode root) {
        return travel(root.left, root.right);
    }

    public boolean travel(TreeNode l, TreeNode r){
        if (l==null && r==null) return true;
        if (l!=null && r!=null){
            return l.val==r.val && travel(l.left, r.right) && travel(l.right, r.left);
        }else{
            return false;
        }
    }
}
