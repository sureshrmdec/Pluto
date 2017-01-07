package com.jiaxin.company.fb.onsite;

public class TrieTree {
	/*
	class TrieNode {
		 boolean isString;
		 HashMap<Character, TrieNode> subtree;
		 public TrieNode() {
			// TODO Auto-generated constructor stub
			 isString = false;
			 subtree = new HashMap<Character, TrieNode>();
		 }
	};


	class TrieTree{
		TrieNode root ;
		public TrieTree(TrieNode TrieNode) {
			root = TrieNode;
		}
		public void insert(String s) {
			TrieNode now = root;
			for (int i = 0; i < s.length(); i++) {
				if (!now.subtree.containsKey(s.charAt(i))) {
					now.subtree.put(s.charAt(i), new TrieNode());
				}
				now  =  now.subtree.get(s.charAt(i));
			}
			now.isString  = true;
		}
		public boolean find(String s){
			TrieNode now = root;
			for (int i = 0; i < s.length(); i++) {
				if (!now.subtree.containsKey(s.charAt(i))) {
					return false;
				}
				now  =  now.subtree.get(s.charAt(i));
			}
			return now.isString ;
		}
	};

	public class Main {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int ty;
			TrieTree tree =  new TrieTree(new TrieNode());
			
			tree.insert("aab");
			tree.insert("aaba");
			tree.insert("aabb");
			tree.insert("aabbb");
			tree.insert("aabcc");
			
			System.out.println(tree.find("aab"));

			System.out.println(tree.find("aabc"));

			System.out.println(tree.find("aabc"));
		}
	}*/
}
