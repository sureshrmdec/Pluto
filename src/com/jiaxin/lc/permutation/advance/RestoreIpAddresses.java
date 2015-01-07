package com.jiaxin.lc.permutation.advance;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
	// "25525511135" --> ["255.255.11.135", "255.255.111.35"].	
	public  List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		
		if (s == null || s.length() > 12) {
			return result;
		}
		
		helper(result, list, s, 0);
		
		return result;
	}

	private void helper(List<String> result, List<String> list, String s, int position) {
		if (list.size() == 4 && position == s.length()) {
			result.add(convertToIp(list));
			return;
		}
		
		for (int i = position; i < s.length(); i++) {
			String ip = s.substring(position, i + 1);
			if (Long.parseLong(ip) < 0 || Long.parseLong(ip) > 255 || (ip.startsWith("0") && ip.length() != 1)) {
				continue;
			}
			
			list.add(ip);
			helper(result, list, s, i + 1);
			list.remove(list.size() - 1);
		}
		
	}

	private String convertToIp(List<String> list) {
		String ip = "";
		for (String str : list) {
			ip += str + ".";
		}
		
		return ip.substring(0, ip.length() - 1);
	}
		
}
