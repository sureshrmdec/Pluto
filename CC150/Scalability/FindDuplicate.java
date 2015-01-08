package CC150.Scalability;
/**
 * 10.4 You have an array with all numbers from 1 to N, where N is at most 32000.
 * The array may have duplicate entries and you do not know what N is. With only 4 kilobytes
 * of memory availbale how would your print all duplicate elements in the array.
 * @author jeffwan
 * @date May 26, 2014
 */
public class FindDuplicate {
	public static void checkDuplicates(int[] array) {
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < array.length; i++) {
			int num = array[i] - 1;
			if (bs.get(num)) {
				System.out.println(num);
			} else {
				bs.set(num);
			}
		}
	}
	
	public static class BitSet {
		int[] bitset;
		public BitSet(int size) {
			bitset = new int[size >> 5]; // divide by 32
		}
		
		boolean get(int position) {
			int wordNumber = (position >> 5);
			int bitNumber = (position & 0x1f);
			return (bitset[wordNumber] & (1 << bitNumber)) != 0;
		}
		
		void set(int position) {
			int wordNumber = (position >> 5);
			int bitNumber = (position & 0x1F);
			bitset[wordNumber] |= 1 << bitNumber;
		}
	}
	
}
