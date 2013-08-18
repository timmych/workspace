//package com.foo.bar.sandbox;
//
//public class checkMinDepth {
//
//    public int md = Integer.MAX_VALUE;
//    
//    public int minDepth(TreeNode root) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        md = Integer.MAX_VALUE;
//        if(root == null){
//            return 0;
//        }
//        checkMinDepth(root, 0);
//        return md;
//    }
//    
//    public void checkMinDepth(TreeNode node, int curdepth){
//        ++curdepth;
//        if(node.left == null && node.right == null){
//            if(curdepth < md){
//                md = curdepth;
//            }
//            return;
//        }
//        if(node.left != null){
//            checkMinDepth(node.left, curdepth);
//        }
//        if(node.right != null){
//            checkMinDepth(node.right, curdepth);
//        }
//    }
//}
