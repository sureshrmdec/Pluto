package interview.ebay;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		String input = "da.exe p1 \"p2 \" op3 "; 
		System.out.println(getParameters(input));
		
		System.out.println(Math.pow(2, 32) / 2 - 1);
		System.out.println(Integer.MAX_VALUE);
	}
	
	public static ArrayList<String> getParameters(String input) {
		if (input == null || input.length() == 0) {
			throw new IllegalArgumentException("Input is not valid");
		}
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) ==' ' && flag == false) {
				if (sb.length() != 0) {
					result.add(filter(sb.toString()));
					sb = new StringBuilder();
				}
			}
			
			if (input.charAt(i) =='"') {
				flag = !flag;
			}
			
			sb.append(input.charAt(i));
		}
		
		if (flag) {
			throw new IllegalArgumentException("Input is not valid");	
		}
		
		
		return result;
	}
	
	public static String filter(String str) {
		if (str.contains("\"")) {
			return str.substring(2, str.length() - 1);
		} else {
			return str;
		}
		
	}
	
}
