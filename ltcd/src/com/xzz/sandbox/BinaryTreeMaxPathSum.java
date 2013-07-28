package com.xzz.sandbox;

import java.util.Arrays;
import java.util.Collections;

import com.xzz.data.TreeNode;

public class BinaryTreeMaxPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode nd = TreeNode.parseTree(new Integer[] { 5, 4, 8, 11, null, 13,
				4, 7, 2, null, null, null, 1 });// new
												// TreeNode(-2).appendLeft(1).appendRight(3);
		System.out.println(new BinaryTreeMaxPathSum().maxPathSum(nd));
	}
	
	public int maxPathSum(TreeNode root) {
		//globalMaxMap = new HashMap<TreeNode, Integer>();
		//localMaxMap = new HashMap<TreeNode, Integer>();
		
		maxSum = root.val;
		getMaxPathSumWithCurNode(root);
		//recVisit(root);
		return maxSum;
	}

	private int maxSum;
//	private Map<TreeNode, Integer> globalMaxMap = new HashMap<TreeNode, Integer>();
//	private Map<TreeNode, Integer> localMaxMap = new HashMap<TreeNode, Integer>();

	public int getMaxPathSumWithCurNode(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getMaxPathSumWithCurNode(root.left);
		int right = getMaxPathSumWithCurNode(root.right);
		int retVal = Collections.max(Arrays.asList(left + root.val, right
				+ root.val,
		// left + root.val + right,
				root.val));
		int localMax = Math.max(left + right + root.val, retVal);
		if(localMax > maxSum){
			maxSum = localMax;
		}
		
		return retVal;
	}
}
