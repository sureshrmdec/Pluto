package com.jiaxin.lc.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	// BFS
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		queue.offer(node);

		while (!queue.isEmpty()) {
			UndirectedGraphNode current = queue.poll();
			
			for (int i = 0; i < current.neighbors.size(); i++) {
				if (!map.containsKey(current.neighbors.get(i))) {
					copy = new UndirectedGraphNode(current.neighbors.get(i).label);
					map.put(current.neighbors.get(i), copy);
					queue.offer(current.neighbors.get(i));
				}
				map.get(current).neighbors.add(map.get(current.neighbors.get(i)));
			}
		}
		
		return node;
    }
	
	// DFS
	public UndirectedGraphNode cloneGrapDFS(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		helperCloneDFS(node, map);
		
		return node;
	}
	
	private void helperCloneDFS(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		for (int i = 0; i < node.neighbors.size(); i++) {
			UndirectedGraphNode current = node.neighbors.get(i);
			if (!map.containsKey(current)) {
				UndirectedGraphNode copy = new UndirectedGraphNode(current.label);
				map.put(current, copy);
				helperCloneDFS(current, map);
			}
			
			map.get(node).neighbors.add(map.get(current));
		}
	}

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
}
