package com.leetcode2025;

import java.util.*;

public class LeeCo102Sol {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;

        queue.add(root);
        int num = 1;

        while (!queue.isEmpty()){
            List<Integer> now = new ArrayList<>();
            int next = 0;
            while (num>0){
                TreeNode r = queue.poll();
                now.add(r.val);
                num--;
                if (r.left!=null){
                    next++;
                    queue.add(r.left);
                }
                if (r.right!=null){
                    next++;
                    queue.add(r.right);
                }
            }
            num = next;
            res.add(now);
        }
        return res;
    }
}
