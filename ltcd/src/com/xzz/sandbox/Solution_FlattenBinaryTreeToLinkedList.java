package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.xzz.data.TreeNode;

public class Solution_FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root) {
		List<TreeNode> lst = new ArrayList<TreeNode>();
		TreeNode tmp = root;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		
		while( !stk.empty() || tmp != null){
			if(tmp != null){
				stk.push(tmp);
				lst.add(tmp);
				tmp = tmp.left;
			}else{
				if(stk.empty())
					break;
				tmp = stk.pop();
				tmp = tmp.right;
			}
		};	
		
		for(int i = 0;  i < lst.size() - 1; ++i){
			lst.get(i).left = null;
			lst.get(i).right = lst.get(i + 1);
		}
		if(lst.size() >= 1){
			lst.get(lst.size() - 1).left = null;
			lst.get(lst.size() - 1).right = null;
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode[] nodes = new TreeNode[7]; 
		for(int i = 1; i < 7; ++i){
			nodes[i] = new TreeNode(i);	
		}
		
		nodes[1].left = nodes[2];
		nodes[1].right = nodes[5];
		nodes[2].left = nodes[3];
		nodes[2].right = nodes[4];
		nodes[5].right = nodes[6];
		
		TreeNode.printTreeInOrder(nodes[1]);
		
		(new Solution_FlattenBinaryTreeToLinkedList()).flatten(nodes[1]);
		TreeNode.printTreeInOrder(nodes[1]);
	}

}
