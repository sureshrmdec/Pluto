package interview.yelp;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * Coding: 
 * 1. 打印出一个array的所有subset。career cup上有，并且提到用那上面提的用整数++的方法。
 * 但是工程师提到这种做法有一个限制，就是当array的长度大于32，这种做法就不行了，问还是要用这个trick，但是怎么修改。
 * 2. 一个矩阵，每个element是一个字母。找出矩阵里的所有valid的单词，假设有一个函数checkDictionary(String)，返回true如果这个单词是valid的。
 * 3. 给一个Node数组，乱序，Node类如下：
	Node {
	    int id;
	    int parent_id;
	    String label; // 如NodeA, NodeB
	}
	要求写一个函数打印如下：
	NodeA
	    NodeB
	        NodeD
	    NodeC
	    NodeG
	NodeF
	    NodeD
 * 
 * 4. Write code to generate all possible case combinations of a given lower-cased string. 
 * (e.g. "0ab" -> ["0ab", "0aB", "0Ab", "0AB"])
 * 
 * 5. implement the 'cd' command i.e. given a function cd('a/b','c/../d/e/../f'), 
 * where 1st param is current directory and 2nd param is the sequence of operations, 
 * find the final directory that the user will be in when the cd command is executed
 * 
 * @author jeffwan
 * @date May 10, 2014
 */
public class Part6 {
	// 1. subset
	public ArrayList<ArrayList<Integer>> subset(int[] A) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    
	    int size = 1 << A.length;
	    
	    for (int i = 0; i < size; i++) {
	        ArrayList<Integer> list = convertList(i, A);
	        result.add(list);
	    }

	    return result;
	}

	public ArrayList<Integer> convertList(int n, int[] A) {
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    int index = 0;
	    
	    for (int i = n; i > 0; i >>= 1) {
	        if ( (i & 1) == 1) {
	            list.add(A[index]);
	        }
	        index++;
	    }
	    
	    return list;
	}
	
	//2. 一个矩阵，每个element是一个字母。找出矩阵里的所有valid的单词，假设有一个函数checkDictionary(String)，返回true如果这个单词是valid的
	// boggle game 的变种题目, 这个每次都得搜到底，因为可能当前词 + new char 在dict中
	boolean[][] visited;
	int m, n;

	public ArrayList<String> searchResult(char[][] board, String target) {
	    ArrayList<String> result = new ArrayList<String>();
	    StringBuilder sb = new StringBuilder();
	    
	    if (board == null || board.length == 0 || board[0].length == 0) {
	        return result;
	    }
	    
	    this.m = board.length;
	    this.n = board[0].length;
	    
	    
	    this.visited = new boolean[m][n];
	    
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            search(result, sb, board, i, j);
	        }
	    }

	    return result;
	}

	public void search(ArrayList<String> result, StringBuilder sb, char[][] board, int i, int j) {
	    sb.append(board[i][j]);
	    visited[i][j] = true;
	    
	    if (checkDictionary(sb.toString())) {
	        result.add(sb.toString());
	    }
	    
	    for (int x = i - 1; x <= i + 1; x++) {
	        for (int y = j - 1; y <= j + 1; y++) {
	            if (x != i && y != j && x >= 0 && x <= m && y >=0 && y <= n && !visited[x][y]) {
	                search(result, sb, board, x, y);
	            }
	        }
	    }

	    sb.deleteCharAt(sb.length() - 1);
	    visited[i][j] = false;
	}
	// just for placeholder
	public boolean checkDictionary(String str) {
		return false;
	}
	
	// 3. Node Print http://stackoverflow.com/questions/14113968/given-parent-node-array-print-out-preorder-traversal-of-the-tree
	public void printNodes(Node[] nodes) {
	    if (nodes == null || nodes.length == 0) {
	        return;
	    }

	    HashMap<Integer, ArrayList<Node>> map = new HashMap<Integer, ArrayList<Node>>();
	    ArrayList<Node> roots = new ArrayList<Node>();
	    
	    for (Node node : nodes) {
	        if (node.parentID == -1) {
	            roots.add(node);
	            continue;
	        }
	        
	        if (!map.containsKey(node.parentID)) {
	            map.put(node.parentID, new ArrayList<Node>());
	        }

	        map.get(node.parentID).add(node);
	    }
	    
	    String tab = "";
	    for (Node node : roots) {
	        printNodeSequence(node, map, tab);
	    }
	}

	public void printNodeSequence(Node node, HashMap<Integer, ArrayList<Node>> map, String tab) {
	    System.out.print(tab);
	    System.out.println(node.label);

	    ArrayList<Node> children = map.get(node.id);    
	    if (children != null) {
	        for (Node child : children) {
	            tab += "\t";
	            printNodeSequence(child, map, tab);
	            tab = tab.substring(0, tab.length() - 1);
	        }
	    }
	}
	
//	public static void main(String[] args) {
//		Node nodeA = new Node(1, -1, "NodeA");
//		Node nodeB = new Node(2, 1, "NodeB");
//		Node nodeC = new Node(3, 1, "NodeC");
//		Node nodeD = new Node(4, 2, "NodeD");
//		Node nodeE = new Node(5, 7, "NodeE");
//		Node nodeF = new Node(6, -1, "NodeF");
//		Node nodeG = new Node(7, 1, "NodeG");
//		
//		Node[] nodes = {nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG};
//		printNodes(nodes);
//	}
	
	// 5. Simplify Path 
	public String simplifyPath(String path) {
	    String result = path.charAt(0) == '/' ? "/" : "";
	    String[] stubs = path.split("/");
	    ArrayList<String> paths = new ArrayList<String>();
	    
	    for (String stub : stubs) {
	        if (stub.equals("..")) {
	            if (paths.size() > 0) {
	                paths.remove(paths.size() - 1);
	            }
	        } else if (!stub.equals(".") && !stub.equals("")) {
	            paths.add(stub);
	        }
	    }  
	    
	    for (String folder : paths) {
	        result += folder + "/";
	    }
	    
	    if (result.length() > 1) {
	        result = result.substring(0, result.length() - 1);
	    }
	    
	    return result;
	}
	
	
	// 5. design cd command -- from careercup
	public static String findResultingDirectory(String currentDirectory,
			String sequenceOfOperations) {

		String splitDirectories[] = sequenceOfOperations.split("/");

		for (int i = 0; i < splitDirectories.length; i++) {
			if (splitDirectories[i].equals("..")) {
				currentDirectory = currentDirectory.substring(0,
						currentDirectory.length() - 2);
			} else {
				currentDirectory = currentDirectory + "/" + splitDirectories[i];
			}
		}

		return currentDirectory;
	}
	
	
	static class Node {
	    public Node(int id, int parentID, String string) {
			this.id = id; this.parentID = parentID; this.label = string;
		}
		int id;
	    int parentID;
	    String label; // 如NodeA, NodeB
	}
	
}
