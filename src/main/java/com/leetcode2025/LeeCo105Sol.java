package com.leetcode2025;


import java.sql.Array;
import java.util.Arrays;

public class LeeCo105Sol {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0) return null;
        if (preorder.length==1) return new TreeNode(preorder[0]);
        int pos = 0;
        for (int i=0; i<inorder.length; i++){
            if (inorder[i]==preorder[0]){
                pos = i;
            }
        }
        return new TreeNode(preorder[0],
                buildTree(Arrays.copyOfRange(preorder, 1, 1+pos), Arrays.copyOfRange(inorder, 0, pos)),
                buildTree(Arrays.copyOfRange(preorder, 1+pos, preorder.length), Arrays.copyOfRange(inorder, pos+1, inorder.length)));
    }
}
