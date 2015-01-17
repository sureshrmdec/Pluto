package com.jiaxin.lc.newProblem;

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

// Implement readline using read 4k

public class Read4KI {

//public class Read4KI extends Reader4 {
/**
* @param buf Destination buffer
* @param n   Maximum number of characters to read
* @return    The number of characters read
*/
	public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		
		int total = 0;
		while (total < n) {
			int temp = read4(buffer);
			
			temp = Math.min(n - total, temp);
			System.arraycopy(buffer, 0, buf, total, temp);
			total += temp;
			
			if (temp < 4) {
				break;
			}
		}
		
		return total;
	}
	
	
	// API funciton
	public int read4(char[] buf) {
		return 0;
	}
}
