package com.xzz.mbbs;

import com.xzz.data.TreeNode;

public class TreeTraverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		n1.setLeft(n2);
		n2.setLeft(n3);
		n2.setRight(n4);
		n4.setLeft(n5);
		n4.setRight(n6);
		n1.setRight(n7);
		n7.setRight(n8);
		new TreeTraverse().traverse(n1);
	}
	
	public void traverse(TreeNode node){
		while(node != null){
			if(node.left == null){
				visit(node);
				if(node.right == null){
					node = node.parent;
					if(node == null){
						break;
					}
					node.left = null;
				}else{
					node.right.parent = node.parent;
					node = node.right;
				}
			}else{
				node = node.left;
			}
		}
	}

	private void visit(TreeNode node) {
		// TODO Auto-generated method stub
		System.out.println(node.val);
	}
}
