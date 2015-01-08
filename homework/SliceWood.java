package homework;

/**
 * Solution: select the maxlength of single tree. binary search the point makes count == length
 * 
 * x + 1 doesn't work. I can improve code here. Do need to make it to the last step
 * max value should be sumlength / length but not shortest tree. because some tree may tall enough and then we don't care shortest.
 * 
 * @author jeffwan
 * @date Apr 25, 2014
 */
public class SliceWood {
	public int sliceWood(int[] woods, int n, int length) {
		if (woods == null || woods.length == 0) {
			return -1;
		}
		
		int sumLength = 0;
		for(int height : woods) {
			sumLength += height;
		}
		
		int start, end, mid;
		
		start = 0;
		end = sumLength / length;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (count(woods, mid) >= length) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		// end first
		if (count(woods, end) == length) {
			return end; 
		} 
		
		if (count(woods, start) == length) {
			return start;
		}

		return -1;
	}
	
	private int count(int[] wood, int mid) {
		int result = 0;
		
		for (int height : wood) {
			result += height / mid; 
		}
		
		return result;
	}
}
