package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeeCo173Sol {

    public BSTIterator bstIterator(TreeNode root) {
        return new BSTIterator(root);
    }

    class BSTIterator {

        List<Integer> l;
        int p = 0;

        public BSTIterator(TreeNode root) {
            l = new ArrayList<>();
            travel(root);
        }

        public void travel(TreeNode root){
            if (root.left!=null) travel(root.left);
            l.add(root.val);
            if (root.right!=null) travel(root.right);
        }

        public int next() {
            int res = l.get(p);
            p++;
            return res;
        }

        public boolean hasNext() {
            return p<l.size();
        }
    }
}
