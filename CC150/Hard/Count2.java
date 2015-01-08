package CC150.Hard;

/**
 * 18.4 Write a method to count the number of 2s that appear in all the numbers between 0 and n.(inclusive).
 * 对每一位, 处理int每一位就是了
 * 
 * @author jeffwan
 * @date May 24, 2014
 */
public class Count2 {
	public static void main(String[] args) {
		System.out.println(numberOf2sInRange(25));
	}

	public static int numberOf2sInRange(int n) {
		if (n <= 1) {
			return 0;
		}
		
		int count = 0;
		for (int i = 2; i <= n; i++) {
			count += numberOf2s(i);
		}
		
		return count;
	}
	
	public static int numberOf2s(int n) {
		int count = 0;
		while (n > 0) {
			if (n % 10 == 2) {
				count++;
			}
			n = n / 10;
		}
		return count;
	}
}
