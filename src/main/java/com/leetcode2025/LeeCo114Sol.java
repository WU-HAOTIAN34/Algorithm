package com.leetcode2025;

import java.util.LinkedList;
import java.util.Queue;

public class LeeCo114Sol {
    Queue<TreeNode> queue = new LinkedList<>();

    public void flatten(TreeNode root) {
        travel(root);
        TreeNode t = new TreeNode();
        while (!queue.isEmpty()){
            t.left = null;
            t.right = queue.poll();
            t = t.right;
        }
    }

    public void travel(TreeNode root){
        if (root==null) return;
        queue.add(root);
        travel(root.left);
        travel(root.right);
    }
}
