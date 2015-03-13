package com.jiaxin.company.fb.online;

/**
 * 1. Conbination Product
 * 2. 1234 -> One Thousand Two Hundred Thirty Four"
 * 3. One edit distance iterator version
 * 
 * return if the distance between a and b is at most 1
 * Distance: minimum number of modifications to make a=b
 * 
 * Modification:
 * 1. change an int in a
 * 2. insert an int to a
 * 3. remove an int from a
 * 
 * tasks: http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=121925&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
 * 
 * 
 * 
 * @author jiashan
 *
 */
public class NewQuestion {
	interface IntFileIterator {
		boolean hasNext();
		int next();
	}

	interface FileCompare {
		public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b);

	}
	// return if the distance between a and b is at most 1..1point3acres缃�
	// Distance: minimum number of modifications to make a=b
	// Modification:
	// 1. change an int in a
	// 2. insert an int to a
	// 3. remove an int from a
	
	// 12321  12321
	// 2321    2321
	int lastA = 0;
	int lastB = 0;
	boolean flag = false;
	
	public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b) {
		if (!a.hasNext() && !b.hasNext()) {
			return true; 
		}
		
		if (a.hasNext() ^ b.hasNext() && !flag) {
			return true; 
		}
		
		int currentA = a.next();
		int currentB = b.next();
		
		// three condition. 
		if (currentA != currentB) {
			// modification 
			
			// add 
			
			// remove 
			
			
		} else {
			return isDistanceZeroOrOne(a, b);
		}
		
		
		return false;
	}
	
	// 12121  2121 not equal -> change? or insert?
	
	
	 public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b) {
		    while (a.hasNext() && b.hasNext()) {
		      int curA = a.next();
		      int curB = b.next();
		      
		      if (curA != curB) {
		        int prevA = curA;
		        int prevB = curB;
		        if (a.hasNext() && b.hasNext()) {
		          curA = a.next();
		          curB = b.next();
		          if (curA != prevB && curB != prevA) {
		            // This means neither prevA nor prevB is the extra item added
		            // In other words, one of them could be changed.
		            if (curA != curB)  
		              return false; // No more difference is allowed 
		            return isSame(a, b); // check if the remaining parts of A and B  are same
		          }
		          
		          if (curA == prevB && curB == prevA) // two different pairs 
		            return false;
		            
		          if (curA == prevB) {
		            // Now there are two possible cases:
		            //  1: prevA is the extra item added
		            //  2: prevA or prevB is the changed item
		            
		            if (curA != curB)
		              return isAdd(a, b, curB);
		            
		            return isAddOrChange(a, b, curB);
		          }
		          
		          // last case: curA == preB
		          if (curA != curB)
		            return isAdd(b, a, curA);
		          
		          return isAddOrChange(b, a, curA);
		        }
		        else if (a.hasNext()) { // && !b.hasNext()
		          curA = a.next();
		          return (!a.hasNext() && curA == prevB); // the second last item in A is added
		        }
		        else if (b.hasNext()) { // && !a.hasNext()
		          curB = b.next();
		          return (!b.hasNext() && curB == prevA); // the second last item in B is added
		        }
		        else { // the last one is different b/w A and B-> one item change
		          return true;
		        }
		      }
		    }
		    
		    if (a.hasNext()) {
		      a.next();
		      return (!a.hasNext()); // the last item in A is added
		    }   
		    if (b.hasNext()) {
		      b.next();
		      return (!b.hasNext()); // the last time in B is added
		    }       
		    return true;
		  }
		  
		  private boolean isSame(IntFileIterator a, IntFileIterator b) {
		    while (a.hasNext() && b.hasNext()) {
		      if (a.next() != b.next())
		        return false;
		    }
		    return !a.hasNext() && !b.hasNext();
		  }

		  private boolean isAdd(IntFileIterator a, IntFileIterator b, int prevB) {
		    if (!a.hasNext())
		      return false;
		    if (a.next() != prevB)
		      return false;
		    return isSame(a, b);
		  }
		  
		  private boolean isAddOrChange(IntFileIterator a, IntFileIterator b, int 
		prevB) {
		    boolean isValidAddCase = true, isValidChangeCase = true;
		    while (a.hasNext() && b.hasNext()) {
		      int curA = a.next();
		      int curB = b.next();            
		      isValidAddCase &= (curA == prevB);
		      isValidChangeCase &= (curA == curB);           
		      if (!isValidAddCase && !isValidChangeCase)
		        return false;           
		      prevB = curB;
		    }
		    
		    if (isValidChangeCase && !a.hasNext() && !b.hasNext())
		      return true; // this is the change case
		    
		    if (isValidAddCase && a.hasNext()) {
		      int curA = a.next();
		      return (curA == prevB) && !a.hasNext();
		    }
		    
		    return false;
		  }
	
}
