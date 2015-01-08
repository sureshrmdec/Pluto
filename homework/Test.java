package homework;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		
		int[] A = {1,1,2,2,3,4,5,5,7};
		System.out.println(Arrays.toString(removeDuplicates(A)));
		System.out.println(Arrays.toString(removeDuplicates2(A)));
	}
	
	public static int[] removeDuplicates(int[] A) {
	    if (A == null || A.length == 0) {
	        return null;
	    }

	    int index = 0;
	    for (int i = 0; i < A.length; i++) {
	        if (i != 0 && A[i] == A[i - 1]) {
	            continue;
	        }
	        A[index++] = A[i];
	    }
	    
	    return A;

	}



	public static int[] removeDuplicates2(int[] A) {
	    if (A == null || A.length == 0) {
	        return null;
	    }
	    
	    int index = 0;
	    for (int i = 0; i < A.length; i++) {
	        int temp = A[i];
	        while (A[i] == temp) {
	            i++;
	        }
	        
	        A[index++] = A[i];
	    }
	    
	    return A;
	}

}
