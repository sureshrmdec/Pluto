package CC150.TreesAndGraphs;

/**
 * 4.1 Implement a function to check if a binary tree is balanced.
 * 
 * 转换成算 MaxDepth
 * 
 * @author jeffwan
 * @date May 6, 2014
 */
public class IsBalanced {
	public boolean isBalanced(TreeNode root) {
	    
	    return maxDepth(root) != -1;
	}

	public int maxDepth(TreeNode root) {
	    if (root == null) {
	        return 0;
	    }
	    
	    int left = maxDepth(root.left);
	    int right = maxDepth(root.right);
	    
	    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
	        return -1;
	    }

	    return Math.max(left, right) + 1;
	}
	
	// TreeNode 
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
}
