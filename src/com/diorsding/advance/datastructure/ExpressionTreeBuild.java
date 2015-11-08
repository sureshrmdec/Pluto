package com.diorsding.advance.datastructure;

/**
 * http://www.lintcode.com/en/problem/expression-tree-build/
 * 
 * For the expression (2*6-(23+7)/(1+2)) 
 * (which can be represented by ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]).
 * 
 * @author jiashan
 *
 */
public class ExpressionTreeBuild {
	
	public ExpressionTreeNode build(String[] expression) {
		
		
		return null;
    }
	
	public class ExpressionTreeNode {
		public String symbol;
		public ExpressionTreeNode left, right;
		public ExpressionTreeNode(String symbol) {
			this.symbol = symbol;
			this.left = this.right = null;
		}
	}
}
