package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;

import com.xzz.data.TreeLinkNode;

public class PopulatingNextRightInEachNode {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null){
            return;
        }
        List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        list.add(root);
        while(list.size() > 0){
            List<TreeLinkNode> tmp = new ArrayList<TreeLinkNode>();
            TreeLinkNode prev = null;
            for(TreeLinkNode node : list){
                if(prev != null){
                    prev.next = node;
                }
                prev = node;
                if(node.left != null){
                    tmp.add(node.left);
                    tmp.add(node.right);
                }
            }
            prev.next = null;
            list = tmp;
        }
    }
    
    public void connect2(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null){
            return;
        }
        List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        list.add(root);
        while(list.size() > 0){
            List<TreeLinkNode> tmp = new ArrayList<TreeLinkNode>();
            TreeLinkNode prev = null;
            for(TreeLinkNode node : list){
                if(prev != null){
                    prev.next = node;
                }
                prev = node;
                if(node.left != null){
                    tmp.add(node.left);
                }
                if(node.right != null){
                    tmp.add(node.right);
                }
            }
            prev.next = null;
            list = tmp;
        }
    }
}
