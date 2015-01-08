package com.jiaxin.cc.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 4.2 Given a directed graph, design on algorithm to find out whether there's a route between two nodes.
 * DFS BFS 都可以做这个题目
 * 就BFS了 
 * 
 * @author jeffwan
 * @date May 6, 2014
 */
public class SearchRoute {
	public enum State {
		unvisited, visited, visiting;
	}
	
	public boolean search (Graph graph, Node start, Node end) {
		Queue<Node> queue = new LinkedList<Node>();
		for (Node node : graph.getNodes()) {
			node.state = State.unvisited;
		}
		
		start.state = State.visiting;
		queue.add(start);
		Node node;
		
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (node != null) {
				for (Node neibourgh : node.getAdjacent()) {
					if (neibourgh.state == State.unvisited) {
						if (neibourgh == end) {
							return true;
						} else {
							neibourgh.state = State.visiting;
							queue.offer(neibourgh);
						}
					}
				}
			}
			node.state = State.visited;
		}
		
		return false;
	}
	
	class Graph {
		public Node[] getNodes() {
			return null;
		}
	}
	
	class Node {
		private State state;
		public Node[] getAdjacent() {
			return null;
		}
	}
}
