package CC150.Moderate;

/**
 * 17.7 Given any integer, print an English phrase that describe the integer. (One Thousand, Two hundred, Thirty Four).
 * 
 * My Solution: 我的思路就是int 分离digit的思路，每次出来判断是第几位(用flag) 标记，然后转换出来对应的word, 注意下顺序什么的就好了，但是Twenty怎么处理？
 * 我的太粗暴了，书上的solution分了集中情况，按int 每3 digit切割，这样更合理.因为不是每位都有对应的 thousand，million这些
 * 
 * 这个分段的思想很重要,这样解决大的切割问题，然后就是每次可复用的对1000之内数的翻译
 * convert(19, 323, 984) = convert(19) + "thousand" + convert(323) + "thousand" + convert(984)
 * 把一个num 转成 一段一段的，每段再处理。这是两层，比我的想法细致多了
 * 
 * Test Case: 这题考察点，有一些Test case要考虑，比如0， 还有负数
 * 
 * @author jeffwan
 * @date May 3, 2014
 */

public class IntToString {
	public static void main(String[] args) {
		System.out.println(numToString(1000000));
	}
	
	public static String[] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	public static String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public static String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Senventy", "Eighty", "Ninety"};
	public static String[] bigs= {"", "Thousand", "Million"};
	
	public static String numToString(int number) {
		if (number == 0) {
			return "Zero";
		} else if (number < 0) {
			return "Negative" + numToString(-1 * number);
		}
		
		int count = 0;
		String str = "";
		while (number > 0) {
			if (number % 1000 != 0) {
				str = numToString100(number % 1000) + bigs[count] + " " + str;
			}
			number /= 1000;
			count++;
		}
		
		return str;
	}

	private static String numToString100(int number) {
		String str = "";
		// Convert hundreds place
		if (number >= 100) {
			str += digits[number / 100 - 1] + " Hundred ";
			number %= 100;
		}

		// Convert tens place
		if (number >= 11 && number <= 19) {
			return str += teens[number - 11] + " ";
		} else if (number == 10 || number >= 20) {
			str += tens[number / 10 - 1] + " ";
			number %= 10;
		}
		
		// Convert ones places
		if (number >= 1 && number <= 9) {
			str += digits[number - 1] + " ";
		}
		
		return str;
	}
}
