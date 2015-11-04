package com.jiashan.flag.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class LintAnagram {

    public boolean anagram(String s, String t) {
        if (s == null && t == null ) {
            return true;
        }
        
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        
        for (char c : s.toCharArray()) {
            if (!dict.containsKey(c)) {
                dict.put(c, 0);
            }
                
            dict.put(c, dict.get(c) + 1);
        }
        
        for (char c : t.toCharArray()) {
            if (!dict.containsKey(c) || dict.get(c) == 0) {
                return false;
            }
                
            dict.put(c, dict.get(c) - 1);
        }
        
        return true;
    }
    
    
    public boolean anagram2(String s, String t) {
        if (s == null && t == null ) {
            return true;
        }
        
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        int[] dict = new int[256];
        
        for (char c : s.toCharArray()) {
            dict[c]++; 
        }
        
        for (char c : t.toCharArray()) {
            if (--dict[c] < 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean compareStrings(String A, String B) {
        if (A == null || B == null) {
            return false;
        }
        
        int[] dict = new int[256]; 
        for (char c : A.toCharArray()) {
            dict[c]++;
        }
        
        for (char c : B.toCharArray()) {
            if (--dict[c] < 0) {
                return false;
            }
        }
        
        return true;
    }
	
    
    public int strStr(String source, String target) {
        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }
        
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j;
            
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i+j) != target.charAt(j)) {
                    break;
                }
            }
            
            if (j == target.length()) {
                return i; 
            }
        }
        
        return -1;
    }
    
    
    public String getTempString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
    
    public String longestCommonPrefixSolution1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        int length = Integer.MAX_VALUE;
        for (String str : strs) {
            length = Math.min(length, str.length());
        } 
        
        int i;
        for (i = 0; i < length; i++) {
            char c = ' ';
            for (String str : strs) {
                if (c == ' ') {
                    c = str.charAt(i);
                } else {
                    if (c != str.charAt(i)) {
                        return str.substring(0,i);
                    }
                }
            }
        }
        
        return strs[0].substring(0, i);
    }
    
    public String longestCommonPrefixSoliution2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String result = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int length = Math.min(str.length(), result.length());
            
            for (int j = 0; j < length; j++) {
                if (result.charAt(j) != str.charAt(j)) {
                    result = result.substring(0, j);
                    break;
                }
            }
            
            if (result.length() > str.length()) {
                result = str;
            }
        }
        
        return result;
    }
    
    
    @Test
    public void test() {
    	String s = "abcd";
    	String t = "aabd";
    	
//    	System.out.println(anagram2(s, t));
    	
//    	System.out.println(strStr("abcdefg", "bcd"));
//    	System.out.println(getTempString("cba"));
    	String[] strs = new String[]{"ABCD", "ABEF", "ACEF"};
//    	System.out.println(strs);
//    	System.out.println(longestCommonPrefix(strs));
    }
    
}

