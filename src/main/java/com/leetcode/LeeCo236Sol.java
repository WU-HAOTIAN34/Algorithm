package com.leetcode;

public class LeeCo236Sol {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==p || root==q || root== null) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if ((l==p && r==q) || (l==q && r==p) ){
            return root;
        }else if(l==null && r==null){
            return null;
        }else if (l!=null){
            return l;
        }else{
            return r;
        }

    }
}
