package com.diorsding.advance.datastructure;

import java.util.ArrayList;
import java.util.List;


/**
 * http://www.lintcode.com/en/problem/find-the-weak-connected-component-in-the-directed-graph/
 * @author jiashan
 *
 */
public class FindWeakConnectedDirectedGraph {

	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
		
		
		return null;
    }
	
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
}
