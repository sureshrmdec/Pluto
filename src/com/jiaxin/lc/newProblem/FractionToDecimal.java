package com.jiaxin.lc.newProblem;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 
 * @author jiashan
 * long deno = Math.abs((long)denominator);
 * long deno = Math.abs(denominator) --> useless
 *
 * Reference: http://blog.csdn.net/ljiabin/article/details/42025037
 */
public class FractionToDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
			return "0";
		}
		
		String result = "";
		
		if ((numerator > 0 && denominator < 0) || (numerator <0 && denominator > 0)) {
			result += "-";
		}
		
		long nume = Math.abs((long)numerator);
		long deno = Math.abs((long)denominator);
		
		result += String.valueOf(nume / deno);
		
		long reminder = (nume % deno) * 10 ;
		if (reminder == 0) {
			return result;
		}
		
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		result += ".";
		
		while (reminder != 0) {
			if (map.containsKey(reminder)) {
				int begin = map.get(reminder);
				String part1 = result.substring(0, begin);
				String part2 = result.substring(begin, result.length());
				
				result = part1 + "(" + part2 + ")";
				return result;
			}
			
			map.put(reminder, result.length());
			result += String.valueOf(reminder / deno);
			reminder = (reminder % deno) * 10;
		}
		
		return result;
    }
	
	@Test
	public void test() {
		System.out.println(fractionToDecimal(-1, Integer.MIN_VALUE));
	}
}
