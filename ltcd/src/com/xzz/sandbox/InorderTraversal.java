package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Stack;

import com.xzz.data.TreeNode;

public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> stk = new Stack<TreeNode>();
        ArrayList<Integer> lst = new ArrayList<Integer>();
        TreeNode node = root;
        //stk.push(node);
        while(true){
            if(node != null){
                stk.push(node);
                node = node.left;
            }else{
                if(stk.size() == 0){
                    break;
                }
                node = stk.pop();
                lst.add(node.val);
                node = node.right;
            }
        };
        
        return lst;
    }
}
