package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class NearestPoints {

    /**
     * Stores a given point in an internal data structure
     */
    
	// void addPoint(Point point);

    /**
     * For given 'center' point returns a subset of 'm' stored points that are
     * closer to the center than others.
     *
     * E.g. Stored: (0, 1) (0, 2) (0, 3) (0, 4) (0, 5)
     *
     * findNearest(new Point(0, 0), 3) -> (0, 1), (0, 2), (0, 3)
     * 
     * Priority Queue
     * http://www.careercup.com/question?id=4758558331633664
     */
    // Collection<Point> findNearest(Point center, int m);
	List<Point> points = new ArrayList<Point>();
	
	void addPoint(Point point) {
		points.add(point);
	}
	
	Collection<Point> findNearest(final Point center, int m) {
		Collection<Point> result = new ArrayList<Point>();
		
		PriorityQueue<Point> heap = new PriorityQueue<Point>(m, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.getDistFromCenter(center) - o2.getDistFromCenter(center);
			}
		});
		
		for (int i = 0; i < points.size(); i++) {
			heap.offer(points.get(i));
		}
		
		for (int i = 0; i < m; i++) {
			result.add(heap.poll());
		}
		
		return result;
	}
    
	@Test
	public void test() {
		Point point1 = new Point(0, 1);
		Point point2 = new Point(0, 2);
		Point point3 = new Point(0, 3);
		Point point4 = new Point(0, 4);
		Point point5 = new Point(0, 5);
		addPoint(point1);
		addPoint(point2);
		addPoint(point3);
		addPoint(point4);
		addPoint(point5);
		
		System.out.print(findNearest(new Point(0,0), 3));
	}
    
    
	class Point {
		int x;
		int y;

		Point() {x = 0;y = 0;}

		Point(int a, int b) {x = a;y = b;}

		public int getDistFromCenter(Point center) {
			return (int) (Math.pow(x - center.x, 2) + Math.pow(y - center.y, 2));
		}

		@Override
		public String toString() {
			return "[" + x + "," + y + "]";
		}
		
    }
    
	public class PointCopy implements Comparable {
		double x;
		double y;
		Double distFromCenter = null;

		public Double getDistFromCenter() {
			return distFromCenter;
		}

		public void setDistFromCenter(double distFromCenter) {
			this.distFromCenter = distFromCenter;
		}

		public PointCopy(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}

		public int compareTo(Object y) {
			Double y_distFromCenter = ((PointCopy) y).getDistFromCenter();
			if (distFromCenter != null && y_distFromCenter != null) {
				if (distFromCenter == y_distFromCenter) {
					return 0;
				} else if (distFromCenter > y_distFromCenter) {
					return 1;
				} else {
					return -1;
				}
			} else
				return 0;
		}
	}
}