package com.xzz.sandbox;

import java.util.Stack;

import com.xzz.data.TreeNode;

public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(true){
            if(cur != null){
                stk.push(cur);
                if(prev != null){
                    prev.left = cur;
                }
                prev = cur;
                cur = cur.left;
            }else{
                if(stk.size() == 0){
                    break;
                }
                cur = stk.pop().right;
            }
        }
        cur = root;
        while(cur != null){
            cur.right = cur.left;
            cur.left = null;
            cur = cur.right;
        }
    }
}
