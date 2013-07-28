package com.xzz.data;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int va){
		this.val = va;
	}
	
	public static TreeNode parseTree(String data){
	    String[] seg = data.split(",");
	    Integer[] list = new Integer[seg.length];
	    int i = 0;
	    for(String s : seg){
	        list[i++] = "#".equals(s) ? null : Integer.valueOf(s);
	    }
	    return TreeNode.parseTree(list);
	}
	
	public static TreeNode parseTree(Integer[] data){
		if(data.length == 0 || data[0] == null){
			return null;
		}
		
		List<TreeNode> nodeList = new ArrayList<TreeNode>(data.length);

		
		for(int id = 0; id < data.length; ++id){
			Integer d = data[id];
			int index = nodeList.size();
			
			if(index == 0){
				nodeList.add(new TreeNode(d));
				continue;
			}

			int parent = (index - 1) / 2;
			int right = (index - 1) % 2;
			
			if(nodeList.get(parent) == null){
				nodeList.add(null);
				nodeList.add(null);
				//backfilled the null values, but still need to work on the current one
				id--;
				continue;
			}
			
			TreeNode newNode = (d == null) ? null : new TreeNode(d);			
			if(right > 0){
				nodeList.get(parent).right = newNode;
			}else{
				nodeList.get(parent).left = newNode;
			}
			nodeList.add(newNode);
		}
		return nodeList.get(0);
	}
	
	public TreeNode appendLeft(int a){
		this.left = new TreeNode(a);
		return this;
	}
	
	public TreeNode appendRight(int a){
		this.right = new TreeNode(a);
		return this;
	}
	
	public static TreeNode genSampleTree(){
		TreeNode[] nodes = new TreeNode[7]; 
		for(int i = 1; i < 7; ++i){
			nodes[i] = new TreeNode(i);	
		}
		
		nodes[1].left = nodes[2];
		nodes[1].right = nodes[5];
		nodes[2].left = nodes[3];
		nodes[2].right = nodes[4];
		nodes[5].right = nodes[6];
		return nodes[1];
	}
	
	public static void main(String[] ar){
		TreeNode test = TreeNode.parseTree(new Integer[]{
			5,4,8,11,null,13,4,7,2,null,null,null,1
		});
		System.out.println(test);
	}
	
	public static void printTreeInOrder(TreeNode root){
		recPrintTreeInOrder(root);
		System.out.println("Å\n");
	}
	
	public static void recPrintTreeInOrder(TreeNode root){
		if(root == null){
		//	System.out.println("Å\n");
			return;
		}
		recPrintTreeInOrder(root.left);
		System.out.printf("%d->", root.val);
		recPrintTreeInOrder(root.right);
	}

}
