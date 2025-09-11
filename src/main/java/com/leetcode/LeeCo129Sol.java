package com.leetcode;

public class LeeCo129Sol {

    int res = 0;
    int now=0;

    public int sumNumbers(TreeNode root) {
        travel(root);
        return res;
    }

    public void travel(TreeNode root){
        now = now*10+root.val;
        if (root.left==null && root.right==null){
            res+=now;
        }else{
            if (root.left!=null) travel(root.left);
            if (root.right!=null) travel(root.right);
        }
        now/=10;
    }

}
