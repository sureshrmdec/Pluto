package com.jiaxin.company.fb.careercup;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

/**
 * Given a function that reads one line a time from a file and returns the line to you. 
 * The line contains comment sign as of "/* *" or even nested signs. 
 * Note the sign doesn't have to be paired in one single line. 
 * Write a function to append all these lines and return them as one single string without comments.
 * 
 * @author jiashan
 *
 */
public class RemoveComment {
	
	public void removeComment(InputStream stdin) {
		boolean flag = false;  // if there's left comment exist
		Scanner sc = new Scanner(stdin);
		String comment = "";
		
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			
			int left = line.indexOf("/*");
			int right = line.indexOf("*/");
			
			if (flag == false) {
				// comment pair in single line (didn't consider many pairs in one line)
				if (left != -1 && right != -1) {
					System.out.print(line.substring(0, left) + line.substring(right + 2));
					// just left comment sign
				} else if (left != -1 && right == -1) {
					System.out.print(line.substring(0, left));
					comment = line.substring(left);
					flag = true;
				} else {
					System.out.println(line);
				}

			// left comment exist
			} else {
				// right comment sign. find complete pair. clean comment. 
				if (left == -1 && right != -1) {
					comment = "";
					System.out.println(line.substring(right + 2));
				}
				
				// there's left comment sign before, we need to keep it but not print
				if (left == -1 && right == -1) {
					comment += line;
				}
			}
			
		}	

		if (flag == true && !comment.isEmpty()) {
			System.out.println(comment);
		}
		
		sc.close();
	}
	
	
	@Test
	public void test() {
		String data1 = "Hello, /*meetqun*/ world \n java or python";  // single line
		String data2 = "Hello, /*meetqun world \n java */ or python"; // /* */ cross line
		String data3 = "Hello, /*meetqun world \n java or python";    // only left /*
		String data4 = "Hello, meetqun world \n java */ or python";   // only right */
		String data5 = "Hello, /*meetqun /*world \n java */ or*/ python";   // overlap
		// overlap like /*aaa /* bb */ 
		// multi comment in one line /*aa*/bbb/*cc*/
				
		System.setIn(new ByteArrayInputStream(data1.getBytes()));
		removeComment(System.in); System.out.println("\n");
		
		System.setIn(new ByteArrayInputStream(data2.getBytes()));
		removeComment(System.in); System.out.println("\n");
		
		System.setIn(new ByteArrayInputStream(data3.getBytes()));
		removeComment(System.in); System.out.println("\n");
		
		System.setIn(new ByteArrayInputStream(data4.getBytes()));
		removeComment(System.in); System.out.println("\n");

		System.setIn(new ByteArrayInputStream(data5.getBytes()));
		removeComment(System.in); System.out.println("\n");
	}
}
