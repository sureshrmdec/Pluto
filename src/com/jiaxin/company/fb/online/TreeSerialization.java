package com.jiaxin.company.fb.online;

import org.junit.Test;


//https://gist.github.com/bittib/5620951
public class TreeSerialization {

	 public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
		
		serializeHelper(sb, root);
		
		return sb.toString().substring(0, sb.length() - 1);
    }
    
    private void serializeHelper(StringBuilder sb, TreeNode root) {
		if (root == null) {
			sb.append("#" + ",");
			return;
		}
		
		sb.append(root.val + ",");
		serializeHelper(sb, root.left);
		serializeHelper(sb, root.right);
	}
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    int i = 0;
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
		
		return deserializeHelper(strs);		
    }
    
    private TreeNode deserializeHelper(String[] strs) {
		if (i > strs.length - 1) {
			return null;
		}
		
		if (strs[i].endsWith("#")) {
			i++;
			return null;
		}
		
		TreeNode node = new TreeNode(Integer.parseInt(strs[i++])); 
		node.left = deserializeHelper(strs);
		node.right = deserializeHelper(strs);
		
		return node;
	}
    
    
    /**
     * 
     *     	  5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
     * 
     * 
     */
    @Test
	public void test() {
		TreeNode node5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node11 = new TreeNode(11);
		TreeNode node13 = new TreeNode(13);
		TreeNode node44 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node55 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		
		node5.left = node4; node5.right = node8;
		node4.left = node11; node8.left = node13; node8.right = node44;
		node11.left = node7; node11.right = node2; node44.left = node55; node44.right = node1;
		
		System.out.println(serialize(node5));
	}
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	/** {5, 4, 8}
	 * 1、第一个数字进队； 
2、每次读2个元素，放在队头的两个儿子上，如果元素是数字则进队； 
3、弹出队头；
	 */
}
