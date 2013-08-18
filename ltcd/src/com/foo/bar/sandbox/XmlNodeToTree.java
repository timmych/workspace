package com.foo.bar.sandbox;

import java.util.Stack;

import com.foo.bar.data.TreeNode;

public class XmlNodeToTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode<String> root = getStringTree("<a>A<b>B<d>D<d1>d1</d1><d2>d2</d2></d><e>e<e1>e1</e1><e2>e2</e2></e></b><c>C</c></a>");
        traverse(root);
    }

    public static TreeNode<Integer> convertToIntTree(TreeNode<String> root) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> intNode = new TreeNode<Integer>(
                Integer.valueOf(root.val));
        intNode.left = convertToIntTree(root.left);
        intNode.right = convertToIntTree(root.right);
        return intNode;
    }

    public static TreeNode<String> getStringTree(String tree) {
        XmlNodeToTree sol = new XmlNodeToTree();
        XmlParser p = sol.new XmlParser(tree);
        String s;
        Stack<TreeNode<String>> stk = new Stack<TreeNode<String>>();
        TreeNode<String> root = null;// = new TreeNode<String>();
        while ((s = p.getNextTag()) != null) {
            if (p.isStartTag()) {
                String str = p.getNextTag();// assert is string tag
                TreeNode<String> node = new TreeNode<String>(str);
                if (stk.isEmpty()) {
                    root = node;
                } else {
                    TreeNode<String> parent = stk.peek();
                    if (parent.left == null) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
                stk.push(node);
            } else if (p.isEndTag()) {
                stk.pop();
            }
        }
        return root;
    }

    private static void traverse(TreeNode<String> root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        System.out.println(root.val);
        traverse(root.right);

    }

    public class XmlParser {
        public int pos;
        public String str;

        public XmlParser(String s) {
            this.str = s;
        }

        private int curType = 0;// 0:start, 1: end, 2:string

        public boolean isStringTag() {
            return curType == 2;
        }

        public boolean isStartTag() {
            return curType == 0;
        }

        public boolean isEndTag() {
            return curType == 1;
        }

        public String getNextTag() {
            if (pos >= str.length()) {
                return null;
            }
            String tag = null;
            int end = -1;
            if (str.charAt(pos) == '<') {
                if (str.charAt(pos + 1) != '/') {
                    end = str.indexOf('>', pos + 1);
                    curType = 0;
                    tag = str.substring(pos + 1, end);
                } else {
                    pos++;
                    end = str.indexOf('>', pos + 1);
                    curType = 1;
                    tag = str.substring(pos + 1, end);
                }
            } else {
                end = str.indexOf('<', pos) - 1;
                curType = 2;
                tag = str.substring(pos, end + 1);
            }
            pos = end + 1;
            return tag;
        }
    }

}
