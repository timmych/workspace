/**
 * 
 */
package com.xzz.sandbox;

import com.xzz.data.TreeNode;

/**
 * @author xiaozhec
 * 
 */
public class SolutionIsBalanced {


    //private HashMap<TreeNode, Integer> treeMap = new HashMap<TreeNode, Integer>();

    public boolean isBalanced(TreeNode root) {
		return checkBalance(root) >= 0;		
	}

	private int checkBalance(TreeNode node) {
		if(node == null)
			return 0;
       // if(treeMap.containsKey(node)){
         //   return treeMap.get(node);
        //}
		int left = checkBalance(node.left);
        if(left == -1)
            return -1;
		int right = checkBalance(node.right);
        if(right == -1)
            return  -1;
		if(Math.abs(left - right) > 1){
			return -1;
		}        
		int retVal = Math.max(left, right) + 1;
    //    treeMap.put(node, retVal);
        return retVal;
	}
}
