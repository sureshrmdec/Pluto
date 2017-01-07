package com.jiaxin.lc.tree.traversal;

import java.util.Stack;


public class FlattenTreeToList {
	public TreeNode lastNode;
	
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		
		if (lastNode != null) {
			lastNode.left = null;
			lastNode.right = root;
		}
		
		lastNode = root;
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
	}

	
	public void flattenIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
 
        while(!stack.empty() || node != null){
 
            if(node.right != null){
                stack.push(node.right);
            }
 
            if(node.left != null){
                node.right = node.left;
                node.left = null;
            }else if(!stack.empty()){
                TreeNode temp = stack.pop();
                node.right=temp;
            }
 
            node = node.right;
        }
    }
	
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
