package CC150.ArraysAndString;

/**
 * 1.7 Write a algorithm such that if a element in an M*N matrix is 0, its entire row and column are set to 0.
 * 书上的写法还是用了 O(m+n)的空间，这里还可以直接in place，用leetcode上当初的做法，第一行和第一列做flag, 不过，要注意不能影响第一行第一列的原结果，
 * 利用的是，如果matrix[i][j] == 0, i,0 && 0,j 早晚要被赋值为0.所以直接拿来做flag也OK
 * 
 * 需要两个boolean来标记是不是原来就有0了，最后赋值0的写法很巧妙，避免了两次双层循环(找行，如果有0，整个行赋值为0，这种太慢了)
 * 我们应该直接对于 i,j 看, i,0 || 0,j 是不是为0，如果是的赋值0就好了，代码上简单一些 
 * 
 * @author jeffwan
 * @date May 5, 2014
 */
public class SetZeros {
	// without extra space solution -- 不是很容易想到
	public void setZeros(int[][] matrix) {
	    int m = matrix.length;
	    int n = matrix[0].length;
	    boolean firstEmptyRow = false;
	    boolean firstEmptyColum = false;
	    
	    for (int i = 0; i < m; i++) {
	        if (matrix[i][0] == 0) {
	            firstEmptyColum = true;
	        }    
	    }

	    for (int i = 0; i < n; i++) {
	        if (matrix[0][i] == 0) {
	            firstEmptyRow = true;
	        }    
	    }
	    
	    for (int i = 1; i < m; i++) {
	        for (int j = 1; j < n; j++) {
	            if (matrix[i][j] == 0) {
	                matrix[i][0] = 0;
	                matrix[0][j] = 0;
	            }
	        }
	    }
	    
	    
	    for (int i = 1; i < m ; i++) {
	        for (int j = 1; j < n; j++) {
	            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
	                matrix[i][j] = 0;
	            }
	        }
	    }
	    
	    if (firstEmptyRow) {
	        for (int i = 0; i < n; i++) {
	            matrix[0][i] = 0;
	        }
	    }

	    if (firstEmptyColum) {
	        for (int i = 0; i < m; i++) {
	            matrix[i][0] = 0;
	        }
	    }
	}
	
	// more general -- use O(n) boolean row , column 来标记
	public void setZeros1(int[][] zeros) {
		if (zeros == null || zeros.length == 0 || zeros[0].length == 0) {
			return;
		}
		
		int m = zeros.length;
		int n = zeros[0].length;
		
		boolean[] row = new boolean[m];
		boolean[] column = new boolean[n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (zeros[i][j] == 0) {
					row[i] = true;
					column[i] = true;
				}
			}
		}
		
		// set zeros
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (row[i] || column[j]) {
					zeros[i][j] = 0;
				}
			}
		}
	}

}
