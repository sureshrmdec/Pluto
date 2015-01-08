package com.jiaxin.company.yelp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1. 一个web crawler，能通过一个url找到另外多个url。例如url 1 to url 2,3,4. url 2 to url 5,6,7.
 * 所有这些都存在一个文本文档里边，问怎么找到path from one url to another one。
 * 2. 一个sorted array of integers，找到magic index.
 * 例如A=[-6,-4,0,3,6,11,22,66] 找到A[3]=3 使用binary search, CC150-9
 * 3. 什么样的排序算法时间复杂度最差
 * 4. 假设你拿到Yelp昨天的log, 里边每一行都保存的是用户的搜索记录, 找出Top 10 query keyword.
 * 
 * @author jeffwan
 * @date May 10, 2014
 */
public class Part1 {
	public static void main(String[] args) {
		int[] nums = {-6, -4, 0, 1, 4, 11, 22, 66};
		File file = new File("/Users/jeffwan/Desktop/query.txt");
		try {
			System.out.println(topkLogs(file, 3));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(findMagicIndex(nums));
	}
	
	// 1. find path between two nodes
	// graph, nodes BFS, better than DFS on huge data processing.
	public UndirectedGraphNode cloneGradph(UndirectedGraphNode node) {
		if (node == null) {
			return node;
		}
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		queue.offer(node);
		
		while (!queue.isEmpty()) {
			UndirectedGraphNode current = queue.poll();
			for (int i = 0; i < current.neighbors.size(); i++) {
				if (!map.containsKey(current.neighbors.get(i))) {
					copy = new UndirectedGraphNode(current.neighbors.get(i).label);
					map.put(current.neighbors.get(i), copy);
					queue.offer(copy);
				}
				map.get(current).neighbors.add(map.get(current.neighbors.get(i)));
			}
		}
		
		return node;
	}
	
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
		if (node == null) {
			return node;
		}
		
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		helper(node, map);
		
		return copy;
	}
	
	private void helper(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		for (int i = 0; i < node.neighbors.size(); i++) {
			UndirectedGraphNode current = node.neighbors.get(i); 
			if (!map.containsKey(current)) {
				UndirectedGraphNode copy = new UndirectedGraphNode(current.label);
				map.put(current, copy);
				helper(current, map);
			}
			map.get(node).neighbors.add(map.get(current));
		}
		
	}


	// 2.一个sorted array of integers，找到magic index. A[3] = 3. 
	public static int findMagicIndex(int[] A) {
	    if (A == null || A.length == 0) {
	        return -1;
	    }

	    int start = 0;
	    int end = A.length - 1;
	    int mid = start + (end - start) / 2;
	    
	    while (start + 1 < end) {
	        mid = start + (end - start) / 2;
	        
	        if (mid == A[mid]) {
	            return mid;
	        }
	    
	        if (mid < A[mid]) {
	            end = mid;
	        } else {
	            start = mid;
	        }
	    }
	    
	    if (A[start] == mid) {
	        return start;
	    }
	    
	    if (A[end] == mid) {
	        return end;
	    }

	    return -1;
	}
	
	/*
	 * 3. 什么样的排序算法时间复杂度最差
	 * 不是冒泡排序 O(n^2). 但是一般情况下用的算法，确实是 冒泡了..  
	 * Permutation sort 这种是最差的，比如 int[], permutation， 找一个sorted. n!.
	 * Random shuffle. 这种就随便抽一种情况看是否sorted，时间复杂度 -- 需要看一下 洗牌算法，以防Follow up
	 */

	/*
	 * 4. 假设你拿到Yelp昨天的log, 里边每一行都保存的是用户的搜索记录, 找出Top 10 query keyword.
	 * Solution 1. 直接用Unix command(他说有bonus): cat -> xargs -> grep -> sort -> uniq -> sort -> head
	 * 这个方法需要试一下，同时也考虑Hadoop，或者Pig这种简单的方法
	 * Solution 2. 写了Java code. 扫描每一行, 放进HashMap<String, Integer>. 然后扔进Heap排序, 之后pop出Top 10.
	 */
	
//	fis = new FileInputStream("the_file_name");
//	br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
//	while ((line = br.readLine()) != null) {
//	    // Deal with the line
//	}

	public static ArrayList<String> topkLogs(File file, int k) throws IOException{
	    FileInputStream fis = new FileInputStream(file);
	    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	    
	    ArrayList<String> result = new ArrayList<String>();
	    HashMap<String, Integer> map = new HashMap<String, Integer>(); 
	    PriorityQueue<KeyWord> heap = new PriorityQueue<KeyWord>();
	    
	    
	    String line;
	    // count query data
	    while ((line = br.readLine()) != null) {
	        if (map.containsKey(line)) {
	            map.put(line, map.get(line) + 1);
	        } else {
	            map.put(line, 1);
	        }
	    }
	    // send to heap
	    for (Map.Entry<String, Integer> entry: map.entrySet()) {
	        KeyWord word = new KeyWord(entry.getKey(), entry.getValue());
	        heap.add(word);
	    }
	    
	    // reteive data from heap
	    for (int i = 0; i < k; i++) {
	        result.add(heap.poll().words);
	        
	    }
	    
	    return result;
	}

	static class KeyWord implements Comparable {
        String words;
        int count;
        KeyWord(String words, int count) {
            this.words = words;
            this.count = count;
        }
		@Override
		public int compareTo(Object o) {
			return ((KeyWord)o).count - this.count;
		}
    }
	
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) {
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
}
