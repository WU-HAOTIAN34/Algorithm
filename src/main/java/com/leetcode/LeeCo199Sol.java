package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeeCo199Sol {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null) return res;
        queue.add(root);
        int num = 1;
        while (!queue.isEmpty()){
            int next = 0;
            while (num>0){

                TreeNode t = queue.poll();
                if (num==1) res.add(t.val);
                if (t.left!= null){
                    next++;
                    queue.add(t.left);
                }
                if (t.right!=null){
                    next++;
                    queue.add(t.right);
                }
                num--;

            }
            num = next;
        }
        return res;

    }

}
