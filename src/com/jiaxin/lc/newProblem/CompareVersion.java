package com.jiaxin.lc.newProblem;

import org.junit.Test;
/**
 * 
 * @author jiashan
 *
 * Test case: "1.0"  "1" -> 0
 * 
 * 
 */
public class CompareVersion {
	public int compareVersion(String version1, String version2) {
		if (version1 == null || version2 == null) {
			return 0;
		}
		
		String[] version1s = version1.split("\\.");
		String[] version2s = version2.split("\\.");
		
		int length = Math.max(version1s.length, version2s.length);
		
		int i = 0;
		
		while (i < length) {
			int c1 = i < version1s.length ? Integer.parseInt(version1s[i]) : 0;
			int c2 = i < version2s.length ? Integer.parseInt(version2s[i]) : 0;
			
			if (c1 > c2) {
				return 1;
			} else if (c1 < c2) {
				return -1;
			} 
			i++;
		}
				
		return 0;
    }
	
	@Test
	public void test() {
		System.out.println(Integer.parseInt("000"));
		System.out.println(Integer.valueOf("000"));
		
		System.out.println(compareVersion("1.0", "1"));	
	}
}
