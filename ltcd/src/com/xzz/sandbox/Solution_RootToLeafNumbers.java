package com.xzz.sandbox;

import com.xzz.data.TreeNode;

public class Solution_RootToLeafNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution_RootToLeafNumbers().sumNumbers(TreeNode.genSampleTree()));
	}
	
	public void recSumNum(TreeNode node, int curSum){
		if(node == null){
			return;
		}
		int nextSum = (curSum * 10 + node.val);
		if(node.left == null && node.right == null){
			retSum += nextSum;
		}
		recSumNum(node.left, nextSum);
		recSumNum(node.right, nextSum);
	}

	private int retSum = 0;
	
	public int sumNumbers(TreeNode root){
		retSum = 0;
		int curSum = 0;
		recSumNum(root, curSum);
		return retSum;
//		TreeNode t = root;
//		int curRate = 1;
//		int curSum = 0;
//		int retSum = 0;
//		Stack<TreeNode> stk = new Stack<TreeNode>();
//		while(!stk.empty() || t != null){
//			if(t != null){
//				stk.push(t);
//				curSum = 10 * curSum + t.val;
//				if(t.left == null && t.right == null){
//					retSum += curSum;
//				}
//			}else{
//				t = stk.pop();
//				
//			}
//		}
	}
}
