package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Stack;

import com.xzz.data.TreeNode;

public class ZigzagTraversal {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Math.pow(46341, 2) - Integer.MAX_VALUE);
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        System.out.println(new ZigzagTraversal().zigzagLevelOrder(TreeNode.parseTree(new Integer[]{
            3,9,20,null,null,15,7
        })));
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> retVal = new ArrayList<ArrayList<Integer>>();
        stk.add(root);
        boolean leftToRight = true;
        while(!stk.empty()){
            Stack<TreeNode> tmp = new Stack<TreeNode>();
            ArrayList<Integer> curLevel = new ArrayList<Integer>();
            while(!stk.empty()){
                TreeNode node = stk.pop();
                if(node == null){
                    continue;
                }
                
                curLevel.add(node.val);
                
                if(leftToRight){
                    tmp.push(node.left);
                    tmp.push(node.right);
                }else{
                    tmp.push(node.right);
                    tmp.push(node.left);
                }
            }
            leftToRight = !leftToRight;
            if(curLevel.size() > 0){
                retVal.add(curLevel);
            }
            stk = tmp;
        }
        return retVal;
    }
}
