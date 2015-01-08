package com.jiaxin.cc.ArraysAndString;

/**
 * 
 * 1.4 Write a method to replace all spaces with "%20". The string has sufficient space at the end of the string. 
 * 
 * 1. Calculate spaces count first, then we know new char[] length 
 * 2. To prevent overlap, start replace from end to head
 *
 * true length < str.length because of input may end with many spaces.
 * length = str.length - end spaces
 * 
 * book use newLength - 1, then newLength--, I use step here.
 */
public class ReplaceSpaces {

	public static void main(String args[]) {
		System.out.println(replaceSpaces("Mr John Smith dsadsa            ".toCharArray(), 20));
	}
	
	public static String replaceSpaces(char[] str, int length) {
	    int spaceCount = 0;
	    for (int i = 0; i < length; i++) {
	        if (str[i] == ' ') {
	        	spaceCount++;
	        }
	    }
	    
	    int newLength = length + spaceCount * 2;
	    str[newLength] = '\0';
	    
	    for (int i = length - 1; i >= 0; i--) {
	        if (str[i] != ' ') {
	            str[newLength - 1] = str[i];
	            newLength--;
	        } else {
	            str[newLength - 1] = '0';
	            str[newLength - 2] = '2';
	            str[newLength - 3] = '%';
	            newLength -= 3;
	        }
	    }
	    
	    return new String(str);
	}
}
