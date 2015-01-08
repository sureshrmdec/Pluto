package CC150.Moderate;

/** 
 * 17.11 Implement a method ran7() give rand5(). 
 * 
 * 这题主要是考虑一个范围，能够平均分布, 最后取所求范围内的即可.
 * 
 * @author jeffwan
 * @date May 24, 2014
 */
public class Rand7Rand5 {
	public int rand7() {
		while (true) {
			int base1 = 2 * rand5(); // even from 0 - 8
			int base2 = rand5(); // for 1 0 generator
			if (base2 != 4) { 
				base2 = base2 % 2;
				int num = base1 + base2; // all numbers from 0 - 9 
				if (num < 7) {
					return num;
				}
			}
		}
	}
	
	public int rand5() {
		return 0;
	}
}
