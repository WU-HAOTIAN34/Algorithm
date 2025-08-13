package com.leetcode2025;

import java.util.ArrayList;
import java.util.List;

public class LeeCo94Sol {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) return res;
        travel(root);
        return res;
    }

    public void travel(TreeNode root){

        if (root.left!=null) travel(root.left);
        res.add(root.val);
        if (root.right!=null) travel(root.right);
    }
}
