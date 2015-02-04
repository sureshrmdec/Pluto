package com.jiaxin.company.linkedin;

public class Pointacres {
	
	//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=115893&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%5B6%5D%3D6%26searchoption%5B3046%5D%5Btype%5D%3Dcheckbox%26sortid%3D311
	//1.http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
	
	//2. http://www.geeksforgeeks.org/a-product-array-puzzle/
	
	//3.Find the shortest distance between two words in a string

	
	//http://www.1point3acres.com/bbs/thread-105717-1-1.html
	
	
	// level order traversal / maximum consecutive sum subarray/ follow up: product array
	
	// valid number(no e) all test case.  / valid triangle, give a array
	// https://gist.github.com/gaoyike/40df1e0ec5a6c95e0014 // https://gist.github.com/gaoyike/26f738493ad5b72a4a77
	
	// pow, construct a string using another string(strinA, stringB, if we can formA use char in B)/ permutation
	
	// thread prcess | 
	// find rorated index/ sorted rotated array
	
	// Given an array of positive integers and two players. In each turn, one player picks up one number and if the sum of all the picked up numbers is greater than a target number, the player wins. Write a program canIWin() to print the result.
	
	// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=102721&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%5B6%5D%3D6%26searchoption%5B3046%5D%5Btype%5D%3Dcheckbox%26sortid%3D311
	
	// nested Integer
   public int getCardinality(String input) {
       int level = 0, sum = 0;
       for (char c : input.toCharArray()) {
               if (c == '{') ++level;
               if (c == '}') --level;
               if (c >= '0' && c <= '9') sum += level * (c - '0');
       }
       
       return sum;
   }
//   
   // thread-safe blocking queue // image of binary tree // nested hashamp, iterator value of map all element
   // http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=99469&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%5B6%5D%3D6%26searchoption%5B3046%5D%5Btype%5D%3Dcheckbox%26sortid%3D311
   
	// isinlist public boolean isInList(float target, float[] list)-->rotated array // printfactors 12 -> 2*6  2*2*3
   
   // 1 million urls from last hour are stored in ->  http://stackoverflow.com/questio ... red-accross-network
   
   // 1.  record hits in last five minitues 
   // 2. most points on line
   
   //nest interface
   //http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=110862&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%5B6%5D%3D6%26searchoption%5B3046%5D%5Btype%5D%3Dcheckbox%26sortid%3D311
   
   // isIsomorphic   
   
   //http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=106498&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%5B6%5D%3D6%26searchoption%5B3046%5D%5Btype%5D%3Dcheckbox%26sortid%3D311
   
}
