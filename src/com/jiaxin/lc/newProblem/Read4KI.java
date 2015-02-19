package com.jiaxin.lc.newProblem;

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

// Implement readline using read 4k

/**
 * case:
 * n = 10, read total finally = 9. (4+4+1) not enough, even n
 * n = 10, read total finally = 10 (4+4+4) enough
 * n = 10, read total finally = 10 (4+4+3) last time
 * 
 * @author jiashan
 *
 */
public class Read4KI {

//public class Read4KI extends Reader4 {
/**
* @param buf Destination buffer
* @param n   Maximum number of characters to read
* @return    The number of characters read
*/
	public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		boolean eof = true;
		int total = 0;
		
		while (eof && total < n) {
			int temp = read4(buffer);
			if (temp < 4) {
				eof = false;
			}
			
			int bytes = Math.min(n - total, temp);
			System.arraycopy(buffer, 0, buf, total, bytes);
			total += bytes;
			
			/*
			if (temp < 4) {
				break;
			}
			*/
		}
		
		return total;
	}
	
	// API funciton
	public int read4(char[] buf) {
		return 0;
	}
}
