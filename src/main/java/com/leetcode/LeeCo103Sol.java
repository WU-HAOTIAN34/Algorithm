package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeeCo103Sol {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Deque<TreeNode> dq = new ArrayDeque<>();
        boolean b = false;
        int now = 1;
        int next = 0;
        dq.add(root);
        while (!dq.isEmpty()){
            List<Integer> l = new ArrayList<>();
            next = 0;
            b = !b;
            while (now>0){
                TreeNode tn;
                if (b){
                    tn = dq.pollLast();
                    if (tn.left!=null){
                        dq.addFirst(tn.left);
                        next++;
                    }
                    if (tn.right!=null){
                        dq.addFirst(tn.right);
                        next++;
                    }
                }else{
                    tn = dq.pollFirst();
                    if (tn.right!=null){
                        dq.addLast(tn.right);
                        next++;
                    }
                    if (tn.left!=null){
                        dq.addLast(tn.left);
                        next++;
                    }
                }
                l.add(tn.val);
                now--;
            }
            res.add(l);
            now = next;
        }
        return res;
    }
}
