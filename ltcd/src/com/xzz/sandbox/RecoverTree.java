package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;

import com.xzz.data.TreeNode;

public class RecoverTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode n  = TreeNode.parseTree(new Integer[]{ 4,5,6,1,3,2,7 });
		TreeNode.printTreeInOrder(n);
		new RecoverTree().recoverTree(n);
		TreeNode.printTreeInOrder(n);
		
		TreeNode m  = TreeNode.parseTree(new Integer[]{ 4,1,6,2,3 });
		TreeNode.printTreeInOrder(m);
		new RecoverTree().recoverTree(m);
		TreeNode.printTreeInOrder(m);
	}
	
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	nodes = new ArrayList<TreeNode>();
    	last = null;
        InorderVisit(root);
        
        if(nodes.size() == 2){
        	int tmp = nodes.get(0).val;
        	nodes.get(0).val = nodes.get(1).val;
        	nodes.get(1).val = tmp;
        }else{
        	int tmp = nodes.get(0).val;
        	nodes.get(0).val = nodes.get(3).val;
        	nodes.get(3).val = tmp;
        }
    }
    
    private List<TreeNode> nodes;
    private TreeNode last;
    
	private void InorderVisit(TreeNode root) {
	    if(root == null){
	    	return;
	    }
	    
	    InorderVisit(root.left);
	    
	    if(last != null && root.val < last.val){
	    	nodes.add(last);
	    	nodes.add(root);
	    }
	    last = root;
	    
	    InorderVisit(root.right);
    }
}
