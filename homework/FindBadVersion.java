package homework;

public class FindBadVersion {	
	public int findBadVersion(int n) {
		int start, end, mid;
		start = 2;
		end = n;
		
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (isBadVersion(mid - 1) == false && isBadVersion(mid) == true ) {
				return mid ;
			}
			
			if (isBadVersion(mid - 1) == false) {
				start = mid;
			}else {
				end = mid;
			}
		}
		
		if (isBadVersion(start - 1) == false && isBadVersion(start) == true) {
			return start;
		}
		
		if (isBadVersion(end - 1) == false && isBadVersion(end) == true) {
			return end;
		}
		
		return -1;
	}
	
	
	public boolean isBadVersion(int version) {
		
		if (version >= 2) {
			return true;
		}
		return false;
	}
}
