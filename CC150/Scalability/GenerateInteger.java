package CC150.Scalability;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.BitSet;
import java.util.Scanner;

/**
 * 10.3 Given an input file with four billion non-negative integer, provide an algorithm to generate an integer
 * which is not contains in the file. Assume you have 1GB of memory available for this task.
 * 
 * @author jeffwan
 * @date May 26, 2014
 */
public class GenerateInteger {
	long numberOfInts = ((long)Integer.MAX_VALUE) + 1;
	byte[] bitfield = new byte[(int)(numberOfInts / 8)];
	
	
	public void findOpenNumbers(String filename) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(filename));
		while (in.hasNextInt()) {
			int n = in.nextInt();
			bitfield[n / 8] |= 1 << (n % 8);
		}
		
		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
				if ((bitfield[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j);
					return;
				}
			}
		}
		
	}
}
