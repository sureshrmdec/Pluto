package interview.yahoo;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Sorted Colors
 * 2. design a deck of cards
 * 3. // A full house is a hand (5 cards) where there are 3 of a kind and a pair. boolean isFullHouse( Card[5] hand)
 * 
 * 4. 找出一个int array中duplicate为2的数返回,考虑一些extend
 * 5. 一个double array，一个double 数，找出离这个数distance最小的数
 * 6. 设计一个blog，post，comment，comment comment
 *  
 * @author jeffwan
 * @date May 13, 2014
 */

public class Part3 {
	public static void main(String[] args) {
//		int[] A = {1,2,1,3,3,3,4,5,6};
//		System.out.println(findDuplicates(A));
		double[] numbers = {1, 2, 4,6,7,7,8};
		
//		System.out.println(findClose(numbers, 3.0));
	}
	
	// 1. sorted colors -- 注意这个i走到blueIndex就够了，否则还得换回来，影响效率。
	public void sorted(int[] A) {
	    if (A == null || A.length == 0) {
	        return;
	    }
	    
	    int redIndex = 0;
	    int blueIndex = A.length - 1;
	    
	    int i = 0;
	    
	    while (i < blueIndex) {
	        if (A[i] == 0) {
	            swap(A, redIndex, i);
	            redIndex++;
	            i++;
	        } else if (A[i] == 1) {
	            i++;
	        } else {
	            swap (A, blueIndex, i);
	            blueIndex--;
	            i++;
	        }    
	    }
	}

	public void swap(int[] A, int i, int j) {
	    int temp = A[i];
	    A[i] = A[j];
	    A[j] = temp;
	}
	
	// 4. find duplicates 2 -- HashMap
	public int findDuplicates(int[] A) {
	    if (A == null || A.length == 0) {
	        return -1;
	    }
	    
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    
	    for (int value : A) {
	        if (map.containsKey(value)) {
	            map.put(value, map.get(value) + 1);
	        } else {
	            map.put(value, 1);
	        }
	    }
	    
	    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	        if (entry.getValue() == 2) {
	            return entry.getKey();
	        }
	    }

	    return -1;
	}
	
	// 5. double[] target double.找距离最小值 -- Test case: [3.0, 5.0] target 有两个值, 需要考虑不？ distance就是差值..不是平方差
	public double findClose(double[] numbers, double target) {
	    if (numbers == null || numbers.length == 0) {
	        return -1;
	    }

	    double min = numbers[0];
	    double minDistance = Math.abs(numbers[0] - target);

	    for (double number : numbers) {
	        double distance = Math.abs(number - target);
	        if (distance < minDistance) {
	            minDistance = distance;
	            min = number;
	        }
	    }

	    return min;
	}
	
	// 6. nodejs的例子来说
	
	
	
	
}
