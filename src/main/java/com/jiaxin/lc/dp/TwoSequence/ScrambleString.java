package com.jiaxin.lc.dp.TwoSequence;

import org.junit.Test;

/**
 * 
 * http://www.lifeincode.net/programming/leetcode-scramble-string-java/
 * 
 * only neighbours can exchange
 * 
 * result[n][i][j] means s1, s2 starts from i,j length = len. if they is scramble. 
 * 
 * i--p----sublen
 * j--p----sublen
 * 
 * i,j,p && i+p, j+p, sublen-p
 * 
 * 
 * i--p----
 * j----p--
 * 
 * i,j+sublen-p,p
 * 
 * i+p,j,sublen-p
 * 
 * @author jiashan
 *
 */
public class ScrambleString {

	// Recursive - Partiton and compare
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false; 
		}
		
//		if (s1.length() == 1 && s2.length() == 1) {
//			return s1.charAt(0) == s2.charAt(0);
//		}
//		
//		char[] s1char = s1.toCharArray();
//		char[] s2char = s2.toCharArray();
//		
//		Arrays.sort(s1char);
//		Arrays.sort(s2char);
//		if (!new String(s1char).equals(new String(s2char))) {
//			return false;
//		}
		
		
		int[] letter = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			letter[s1.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < s2.length(); i++) {
			letter[s2.charAt(i) - 'a']--;
		}
		
		for (int i = 0; i < letter.length; i++) {
			if (letter[i] != 0) return false;
		}
		
		if (s1.length() == 1 && s2.length() == 1) return true;
		
		
		for (int i = 1; i < s1.length(); i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);
			
			if (isScramble(s11, s22) && isScramble(s12, s21)) {
				return true;
			}
			
			s21 = s2.substring(0, s2.length() - i);
			s22 = s2.substring(s2.length() - i);
			
			if (isScramble(s11, s22) && isScramble(s12, s21)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isScrambleDP(String s1, String s2) {  
		if(s1.length() != s2.length()) {  
            return false;  
        }  
		
		int len = s1.length();  
          
        boolean[][][] canScramble = new boolean[len][len][len+1];   // i,j with sublength  
        for (int i = 0; i < len; i++) {  
            for (int j = 0; j < len; j++) {  
                canScramble[i][j][1] = s1.charAt(i) == s2.charAt(j);    // substring start from i with length 1, compared with substring start from j with length 1  
            }  
        }  
          
        for (int sublen= 2; sublen <= len; sublen++) {  
            // end_pos = x+(sublen-1) <= len-1, so x <= len-sublen  
            for (int i = 0; i <= len - sublen; i++) {  
                for (int j = 0; j <= len - sublen ; j++) {  
                    for(int p = 1; p < sublen; p++) {       // split position  
                        canScramble[i][j][sublen] |= (canScramble[i][j][p] && canScramble[i+p][j+p][sublen-p]) ||   
                                                     (canScramble[i][j+sublen-p][p] && canScramble[i+p][j][sublen-p]);  
                    }  
                }  
            }  
        }  
          
        return canScramble[0][0][len];  
    }  
	
	
	
	@Test
	public void test() {
		System.out.println(isScramble("sqksrqzhhmfmlmqvlbnaqcmebbkqfy", "abbkyfqemcqnblvqmlmfmhhzqrskqs"));
		System.out.println(isScrambleDP("sqksrqzhhmfmlmqvlbnaqcmebbkqfy", "abbkyfqemcqnblvqmlmfmhhzqrskqs"));
		System.out.println(isScrambleDP("abcd", "bdac"));
		System.out.println(isScrambleDP("abcd", "bdac"));
		
	}
}
