package com.jiaxin.company.linkedin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;

/**
 *  * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=113331&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%5B6%5D%3D6%26searchoption%5B3046%5D%5Btype%5D%3Dcheckbox%26sortid%3D311
 * 
 * Implement a (Java) Iterable object that iterates lines one by one from a text file.
 * public class TextFile implements Iterable<String> {
 * 		public TextFile(String fileName) { // please implement this

  Begin reading the file, line by line. The returned Iterator.next() will return a line. 
  	@Override
	   public Iterator<String> iterator() {
	    // please implement this
	   }
 * @author jiashan
 *
 */
public class TextFile implements Iterable<String> {

// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=106362&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%5B6%5D%3D6%26searchoption%5B3046%5D%5Btype%5D%3Dcheckbox%26sortid%3D311
	//http://stackoverflow.com/questions/4677411/iterating-over-the-content-of-a-text-file-line-by-line-is-there-a-best-practic
	
	// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=94989&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%5B6%5D%3D6%26searchoption%5B3046%5D%5Btype%5D%3Dcheckbox%26sortid%3D311
	final String fileName;
    
    public TextFile(String fileName) {
    	this.fileName = fileName;
    }

	@Override
	public Iterator<String> iterator() {
		return new TextFileIterator();
	}
	
	class TextFileIterator implements Iterator {
		BufferedReader in;
		String nextLine;
		
		public TextFileIterator() {
			try {
				in = new BufferedReader(new FileReader(fileName));
				nextLine = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		@Override
		public boolean hasNext() {
			return nextLine != null;
		}

		@Override
		public Object next() {
			try {
				String result = nextLine;
				if (nextLine != null) {
					nextLine = in.readLine();
					
					if (nextLine == null) {
						in.close();
					}
				}
				return result;
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			
			return in;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
