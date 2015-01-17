package com.jiaxin.lc.newProblem;


/* The read function may be called multiple times.
 * The previous one we can't use it for multiple times since read4 actually read more and break continuity.
 * This one will sovle that problem.
 * 
 */

/* public class Solution extends Reader4 { */
public class Read4KII {
	int offset = 0;
	int bufSize = 0;
	char[] offsetBuffer = new char[4];
	
	// "abc" read(1) read(4) read(1)- OutofIndex
	public int read(char[] buf, int n) {
		char[] buffer = new char[4];

		int total = 0;
		while (total < n) {
			if (offset > 0) {
				System.arraycopy(offsetBuffer, 0, buf, total, Math.min(offset, n));
				total += offset;
				offset -= Math.min(offset, n);
			}
			
			int temp = read4(buffer);
			
			int copyLength = Math.min(n - total, temp);
			System.arraycopy(buffer, 0, buf, total, copyLength);
			total += temp;

			offset = temp - copyLength;
			
			if (copyLength < 4) {
				break;
			}
		}

		bufSize += total;
		return total;
	}
	
	
	// API funciton
	public int read4(char[] buf) {
		return 0;
	}
}
