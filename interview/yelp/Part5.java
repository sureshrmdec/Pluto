package interview.yelp;

import java.util.Arrays;

/**
 * Phone Interview
 * 1. 最后问了一个log处理的算法，Gb级别的log，每一行都是一个URL，要求拿到出现频率最高的100条
 * 
 * 2. reverse words in a string. Iterative & recursive way
 * 
 * 3. 说有个一个docment collection，d0,d1,d2,d3....和一个iterator，iterator的构造器接收一个word： -- 放掉了
	iterator(word):
    next(): return (docId, pos)
    hasnext()
    skip(docId, pos)

iterator的next返回的是下一个含有该word的doc id和该word在这个doc里的位置。skip让iterator送指定的doc的指定位置接着iterate。
用这个iterate返回所有含有“happy hour”的doc id和这个phrase在这些doc里出现的位置。
恰巧最近上的information retrieval的课上，讲到了boolean query的算法，基本上思路就是给happy和hour这两个词分别建立一个iterator，然后把含有这两个词的doc看作两个list，首先要找到同时含有这两个词的doc，然后再判断这两个词是不是一前一后正好形成这个phrase。我最后写出了还算正确的解决方案。不然估计又死翘翘了。
 * 
 * @author jeffwan
 * @date May 10, 2014
 */
public class Part5 {
	public static void main(String[] args) {
//		System.out.println('['+reverseWords("  ") +']');
		
		System.out.println(reverseEveryWord("hello. niya sadada sword."));
	}
	
	/*
	 *  1. 海量log， 每一行是一个URL， 拿到出线频率最高的100 URL
	 *  -- load in memory, 直接HashMap, 然后minMum Heap, push them in --> find the first 100. nlog(k)
	 *  -- can't load in memory, split into small files. Hash(url) % 1000 --> 确保相同的在一个file
	 *  	构建HashMap, key is url, value is occurence. merge. --> Heap
	 *  key 是不是太长了？
	 *   
	 */
	
	// 2. Reverse words in a String, 
	// 细节: split 必须用" ", 不然是切出来一个字符一个字符的， 然后word.equals(""), 因为切出来有""的，边界
	public String reverseWordSequence(String s) {
	    if (s == null || s.length() == 0) {
	        return "";
	    }

	    String[] words = s.split(" ");
	    String result = "";
	    
	    for (String word : words) {
	        if (!word.equals("")) {
	            result = word + " " + result;
	        }
	    }
	    
	    return result.length() == 0? result : result.substring(0, result.length() - 1);
	}
	
	// Extends: reverse every word in a string 上一个题目，reverse 单词的顺序，每个单词内部顺序不变，总的变，这个相反,每个内部边，总的不变.
	// split ,reverse every word, append. 同样很轻松
	public static String reverseEveryWord(String s) {
	    if ( s == null || s.length() == 0) {
	        return null;
	    }    
	    
	    String result = "";
	    
	    for (int i = 0; i < s.length(); i++) {
	        int start = i;
	        while (i < s.length() && s.charAt(i) != ' ' && s.charAt(i) != '.') {
	            i++;
	        }
	    
	        result += reverseWord(s.substring(start, i));
	        if (i < s.length()) {
	        	result += s.charAt(i); // add the space or comma
	        }
	    }
	    
	    return result;
	}
	
	public static String reverseWord(String word) {
	    String newWord = "";
	    
	    for (int i = word.length() - 1; i >= 0; i--) {
	        newWord += word.charAt(i);
	    }
	    
	    return newWord;
	}
	
	// 3. Document Collection
	
	
}
