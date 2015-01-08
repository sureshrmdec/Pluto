package CC150.SortingAndSearching;

/**
 * Binary Search target String.
 * 变种题 String[] 是sorted，但是里面有一些"" 空String. 如何解决 -- 碰到""， 把mid移到left or right最近的不空位
 * @author jeffwan
 * @date May 18, 2014
 */
public class FindString {
	public int search(String[] strings, String str) {
		if (strings == null || strings.length == 0|| str == null || str == "") {
			return -1;
		}
		return search(strings, str, 0, strings.length - 1);
	}

	private int search(String[] strings, String str, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2; 
		if(strings[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;
			while (true) {
				if (left < start && right > end) {
					return - 1;
				} else if (right <= end && !strings[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= start && !strings[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}
		
		if (str.equals(strings[mid])) {
			return mid;
		} else if (str.compareTo(strings[mid]) < 0) {
			return search(strings, str, start, mid - 1);
		} else {
			return search(strings, str, mid + 1, end);
		}
	}
}
