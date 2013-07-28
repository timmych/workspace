package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Stack;

import com.xzz.data.TreeNode;

public class BinaryLevelTraversalII {
    /**
     * Definition for binary tree public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();

        if (root != null) {
            nodes.add(root);
        }

        while (nodes.size() > 0) {
            ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (TreeNode n : nodes) {
                row.add(n.val);
                if (n.left != null) {
                    tmp.add(n.left);
                }
                if (n.right != null) {
                    tmp.add(n.right);
                }
            }
            lst.add(row);
            nodes = tmp;
        }
        return lst;
    }
    
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>();
        Stack<ArrayList<Integer>> stk = new Stack<ArrayList<Integer>>();
        
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        
        if(root!= null){
            nodes.add(root);
        }
        
        while(nodes.size() > 0){
            ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(TreeNode n : nodes){
                row.add(n.val);
                if(n.left != null){
                    tmp.add(n.left);
                }
                if(n.right != null){
                    tmp.add(n.right);
                }
            }
            //lst.add(row);
            stk.push(row);
            nodes = tmp;
        }
        while(stk.size() > 0){
            lst.add(stk.pop());
        }
        return lst;
    }
}
