package com.jiaxin.cc.MathematicsAndProbability;

/**
 * Problem 7.3: Given two lines on a Cartesian plane, determine whether the two lines would intersect.
 * 
 * Solution: 
 * I assume two points means a line, but who tells me? Ask interviewer this kind of quesiton. 
 * Solution on book use scope and yintercept to present a line.
 * 
 * TestCase: two lines are same
 * 
 * @author jeffwan
 * @date Feb 26, 2014
 */
public class Line {

	static double epsilon = 0.000001;
	public double scope;
	public double yIntercept;
	
	public Line (double scope, double yIntercept) {
		this.scope = scope;
		this.yIntercept = yIntercept;
	}
	
	public boolean isIntersect(Line line2) {
		return Math.abs(scope - line2.scope) > epsilon ||
				Math.abs(yIntercept - line2.yIntercept) < epsilon;
	}
}
