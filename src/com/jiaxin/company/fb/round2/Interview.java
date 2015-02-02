package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author jiashan
 * Given a string that which is in JSON format, print it in a human readable way. 
 * For example" {'a':'1', 'b':['c':'2','d':'3']}" should output:
 *  a:1
    b:[
      c:2
      d:3
      ]
 */
public class Interview {
	// http://www.meetqun.com/forum.php?mod=viewthread&tid=5589&extra=page%3D1%26filter%3Dtypeid%26typeid%3D1
	public String prettyJSON(String input){
		StringBuilder sb = new StringBuilder();
		
		int i = 0;
		int space = 0;
		
		while (i < input.length()) {
			int j = 0;
			// pre tab
			while (j < space) {
				sb.append(" ");
				j++;
			}
			
			while (i < input.length()) {
				char c = input.charAt(i);
				if (isLeftBracket(c)) {
					sb.append(c);
					sb.append('\n');
					space += 2;
					i++;
					break;
				} else if (c == ','){
					sb.append('\n');
					i++;
					break;
				} else if (isRightBracket(c)) {
					sb.append('\n');
					space -= 2;
					int k = 0;
					while (k < space) {
						sb.append(' ');
						k++;
					}
					sb.append(c);
					i++;
					break;
				} else if (c == '\'') {
					i++;
				} else {
					sb.append(c);
					i++;
				}
			}
		}
		
		return sb.toString();
	}

	private boolean isLeftBracket(char c) {
		return c == '{' || c == '[';
	}
	
	private boolean isRightBracket(char c) {
		return c == '}' || c == ']';	
	}
	
	
	// http://www.meetqun.com/forum.php?mod=viewthread&tid=596&extra=page%3D1%26filter%3Dtypeid%26typeid%3D1
	// if point can form Polygon
	
	// http://www.meetqun.com/forum.php?mod=viewthread&tid=4505&extra=page%3D1%26filter%3Dtypeid%26typeid%3D1
	// 1. Tree all path 2. String isPalindrome
	public List<List<Integer>> treePath(TreeNode root) {  // same to path sumII
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		pathHelper(result, list, root);
		
		return result;
	}
	
	private void pathHelper(List<List<Integer>> result, List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			list.add(root.val);
			result.add(new ArrayList<Integer>(list));
			list.remove(list.size() - 1);
		}
		
		list.add(root.val);
		pathHelper(result, list, root.left);
		pathHelper(result, list, root.right);
		list.remove(list.size() - 1);
	}

	// http://www.meetqun.com/forum.php?mod=viewthread&tid=5394&extra=page%3D2%26filter%3Dtypeid%26typeid%3D1
	// ksum I, II, how many solutions? all solutions? 
	
	// http://www.meetqun.com/forum.php?mod=viewthread&tid=3030&extra=page%3D3%26filter%3Dtypeid%26typeid%3D1
	// reverse linked list   a-b-c-d- _ -t-r-e-e- _ -o-n  result:  d-c-b-a- _ - e-e-r-t- _ - n-o  _ is space as value.
	// 
	
	
	// http://www.meetqun.com/forum.php?mod=viewthread&tid=5352&extra=page%3D5%26filter%3Dtypeid%26typeid%3D1
	// double sqrt
	
	
	// http://www.meetqun.com/thread-5053-2-1.html isPalindrome + follow up
	
	//http://www.meetqun.com/forum.php?mod=viewthread&tid=606&extra=page%3D7%26filter%3Dtypeid%26typeid%3D1 print tree 
	//What if it's a directed graph instead of a tree? print paths from root to all leaf nodes, one path per line.
	
	
	// http://www.meetqun.com/forum.php?mod=viewthread&tid=5136&extra=page%3D8%26filter%3Dtypeid%26typeid%3D1
	// read writer mutate problem lock release
	
	// http://www.meetqun.com/thread-531-3-1.html post order to print level
	
	//http://www.meetqun.com/forum.php?mod=viewthread&tid=5087&extra=page%3D10%26filter%3Dtypeid%26typeid%3D1
	
	@Test
	public void test() {
		String input = "{'meau':{'id':'file','value':'File'," +
				"'popup':{'menuitem':[{'value':'new','onclick':'CreateNewDoc()'}," +
				"{'value':'Open','onclick':'OpenDoc()'}]}}}";
		
		System.out.println(prettyJSON(input));
		
		TreeNode node5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node11 = new TreeNode(11);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		
		node5.left = node4; node5.right = node8;
		node4.left = node11; node11.left = node7; node11.right = node2;
		
		System.out.println(treePath(node5));
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
}
