package CC150.Moderate;

/**
 * 17.3 Write an algorithm which computed the number of trailing zeros in a n factorial(阶乘的意思).
 * 我自己写的明显不如书上的清晰
 * @author jeffwan
 * @date May 24, 2014
 */

public class TrailingZeros {
	public static void main(String[] args) {
		System.out.println(calculateZeros(126));
		System.out.println(countFactZeros(126));
	}
	
	public static int calculateZeros(int n) {
		if (n < 0) {
			return -1;
		}
		
		int factor = 1;
		int sum = 0;
		
		while (n / (5 * factor) != 0) {
			sum  += n / (5 * factor);
			factor *= 5;
		}
		
		return sum;
	}
	
	// Solution on book
	public static int countFactZeros(int num) {
		int count = 0;
		if (num < 0) {
			return -1;
		}
		
		for (int i = 5; num / i > 0; i *= 5) {
			count += num / i;
		}
		
		return count;
	}
	
}
