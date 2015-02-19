package com.jiaxin.company.fb.online;

public class MeetQun1 {
	/**
	 * intern Onsite: http://www.meetqun.com/thread-5087-1-1.html
	 * 1.imitate cd. simplify path
	 * 2. 1=>[A,B,C], 2=>[D,E,F]. give a integer, find all char conbination
	 * 3. find bad version
	 * 3. actual number array : [4 2 1 5 3] position array : [3 1 0 4 2]# => actual number array [1 2 3 4 5]:
	 * 
	 * Phone
	 * 1. level order traversal
	 * 2. sqrt double
	 * 
	 * onsite:http://www.meetqun.com/thread-5589-1-2.html
	 * Given a string that which is in JSON format, print it in a human readable way. 
	 * For example" {'a':'1', 'b':['c':'2','d':'3']}" should output:
	 * a: 1
	 * b: [
	 *  c:2
	 *  d:3
	 *  ] 
	 *
	 * on-campus http://www.meetqun.com/thread-6216-1-2.html
	 * 1. Reverse print a link list, do not use extra memory
	 * 2. 2. Using Stack to implement a Queue
	 * 3. dict = [this, th, is, a good day] st = "thisisagoodday"  word breakII
	 * 
	 * 
	 * phone: http://www.meetqun.com/thread-5779-1-3.html
	 * task schedule: task list,  ABCDAABA, cool down is 2, every task takes 1. 
	 * total needs 11. ABCDA_ _AB_ A under line is waiting time.
	 * 
	 * 我的思路是跟LZ差不多，我是用Java的, 用HashMap 记录每个task(no matter char or other object), 
	 * value 是index， 每次到一个task, 去hashMap 查询，如果查得到，并且currentIndex - index + 1 < 2. 
	 * 时间就要补差值 1 or 2. 如果其他的情况，都可以直接运行task，然后更新hashMap
	 * 
	 * FB phone: 什么版主大作，
	 * regular expression matching
	 * onsite:
	 * 1.decode ways
	 * 2.sort coloes
	 * 3.isBST
	 * 4.word ladderII -> follow up
	 *
	 * Phone:
	 * 1. all tree path
	 * 2. string ispalindrom
	 * 
	 * Phone:
	 * 1. copy graph
	 * 
	 * Phone:
	 * 1. one edit distance
	 * 2. count and say
	 * 3. regular expression
	 * 
	 * Phone: http://www.meetqun.com/thread-3789-1-4.html
	 * 1. trapping rain water
	 * 2. follow up: 0 means lou shui
	 *
	 * Onsite: http://www.meetqun.com/thread-6059-1-4.html
	 * 1. matrix, binary search, row up, column up
	 * 2. list of string anagram
	 * 3. a list of segment. find the one segment with others most
	 * [1,3] [2,4] [7,8] [4,5]  return [2,4]. because [1,3] intersect with [4,5]
	 * 
	 * 
	 * Phone:
	 * "password". a cound be A,a,@. you have a dict. create create a function 
	 * that find all possible combination of the password
	 * 
	 * 
	 * Phone: 
	 * 1. isPalindrome
	 * 2. anagram
	 * 
	 * Phone: 
	 * 1. count and say
	 * 2. find kth node in BST
	 * 
	 * Phone:
	 * 1. best time to sell stock 
	 * 2. isBST
	 * 
	 * Phone: http://www.meetqun.com/thread-3030-1-11.html
	 * 1. linkedlist   a-b-c-d- _ -t-r-e-e- _ -o-n    ->   d-c-b-a- _ - e-e-r-t- _ - n-o 
	 * 
	 * Phone:
	 * 1. stocks
	 * 2. oneeditDistance
	 * 
	 * Phone:
	 * 1. stair climbing | different ways, solutions? 
	 * 
	 * phone:http://www.meetqun.com/forum.php?mod=viewthread&tid=4535
	 * 1. int matrix, 0 empty, 1 obstacle. find where there's a path between 2 nodes. 
	 * 2. Given a string list，find all pairs of strings which can be combined to be a palindrome. 
	 * eg: cigar + tragic -> cigartragic, none + xenon -> nonexenon
	 * 3. find distance between two nodes in a binary tree
	 * 
	 * 
	 * phone: http://www.meetqun.com/thread-596-1-12.html
	 * points to form duobianxing
	 * 
	 * phone:
	 *  1.[2,1,2,1,5,4,5,5]  return one of 4 6 7, return maxvalue's index O(1)space
	 *  2. word search I
	 *  3. 3sum
	 *  
	 * Phone: 
	 * 1. sort colors
	 * 2. reverse linked list
	 * 3. implement / using +
	 * 
	 * Phone: http://www.meetqun.com/thread-5245-1-13.html
	 * 1. print all path of a bST
	 * 2. Follow: Print all path of a graph with one starting point, multiple terminating points
	 * 
	 * Phone:
	 * 1. 2sum 3sum ksum
	 * 2. merge two sorted array in place
	 * 
	 * Phone: http://www.meetqun.com/thread-5356-1-16.html
	 * coole down. task schduler. follow up: colddown is a param, how to modify your code.
	 * 
	 * intern onsite:
	 * 1.word break
	 * 2. index of max value. need randomly
	 * 
	 * Phone:
	 *  print binary tree.
	 * 
	 * What if it's a directed graph instead of a tree? 
	 * print paths from root to all leaf nodes, one path per line.
	 * 
	 * class Node {
	 * 	String val;
	 *  ArrayList<Node> children;
	 * }
	 * 
	 * 
	 * Phone:
	 * isPalindrome followup
	 * 抱歉说的不是很清楚，不是判断是否UTF8. 而是判断char[]是否是回文，只是字符集是UTF8.假设字符都是valid的。
	 * UTF8的字可以由一个char，二个char或者三个char组成。读第一个char可以知道是几个char组成一个字。
	 * 所以先假设有个函数getLen(char c)可以得到长度N，然后，左边i移动N，右边的j也移动N，比较这部分是否相等。
	 * 可以包个函数isSameIgnoreCaseUTF8(int i, int j, int len)$ y
	 * http://www.meetqun.com/thread-5053-2-1.html
	 * http://www.meetqun.com/thread-5042-1-1.html
	 * 
	 * onsote:
	 * 1. read4k
	 * 2. reverse linklist + regular expression matching
	 * 3. reader writer problem with mutex roman to integer
	 * 4. one edit distance
	 * 
	 * Phone: 
	 * 1. find peak
	 * 2. 有N个区间，求一个点，这个点与最多的区间相交，并返回相交的数目。
	 * http://www.meetqun.com/thread-5192-1-21.html
	 * 
	 * Phone:
	 * 1. pre-fix String search --> build trie tree.
	 * 2. String evaluation: eg.  Given 3 +2x +5y -(3 +5x) = 8 -7y +2x and X value，return Y value
	 * http://www.fgdsb.com/2015/01/08/parse-formula/
	 * 
	 * Phone:
	 * 1. climbing stairs，要求返回所有解，并且写出单元测试，分析时间空间复杂
	 * 2. climbing stairs，要求只打印所有解，分析现在的空间复杂
	 * 3. climbing stairs，要求只返回解的个数，要求O(N)+O(1
	 * 3. climbing stairs，还是只返回解的个数，但是时间要求O(logN)。这个是optional的，答不出来没关系。
	 * 
	 * Phone:
	 * 1. 走迷宫，0 1， BFS or DFS
	 * 
	 * onsite:
	 * http://www.meetqun.com/thread-552-1-25.html
	 * 
	 * Phone:
	 * Unique Path I && II
	 * 
	 * Phone:
	 * http://www.meetqun.com/thread-4776-1-27.html Weight Random Selection
	 * 
	 * Phone:
	 * regular expression string tree to string
	 * http://www.meetqun.com/thread-541-1-30.html
	 * 
	 * BST Iterator
	 * array, non 0 move to left, 0 move to right;
	 * merge k sorted list 
	 * 
	 * Sort List
	 * merge two sorted array and N sorted array. -> heap
	 * 
	 * ragular expression. no +
	 * 
	 * array, find length = k sequence(not subarray). with maxsum  
	 * count sort? limit 1-9 
	 * 
	 * phone number combination
	 * 
	 * edit distance <2 
	 * 
	 * Tree Seriliazation
	 * http://www.meetqun.com/thread-469-1-16.html
	 * 
	 * find 1s number in binary format  -> hamming weight, popcount
	 * 
	 * wildcard matching
	 * 
	 * many points, find min r cound cover all points
	 * http://www.meetqun.com/thread-3005-1-45.html
	 * 
	 * fibonacci 矩阵乘法 logn?
	 * 
	 * str str call many times?
	 * 
	 * check if a bipartite path
	 * 
	 * Minimum Window Substring input： String s= "aaccbc", dict = “abc”， 输出: "accb" 这里的dict, 里面不含重复字母，
	 * 
	 * median of integer stream
	 * 
	 * 有N个区间，求一个点，这个点与最多的区间相交，并返回相交的数目，也是老题目，在被提示后作出来
	 * Wordament
	 * 
	 * trie tree, strstr. call o(1)?
	 * 
	 * meetings
	 * http://www.meetqun.com/thread-2627-1-53.html
	 * 
	 * 
	 * onsite:http://www.meetqun.com/thread-970-1-55.html
	 * 
	 * 写个函数，找输入给定string里面出现频率最高的word。 比如 This is island.   输出： is ??
	 * 
	 * oncampus
	 * http://www.meetqun.com/thread-1830-1-56.html
	 * 
	 * one edit http://www.meetqun.com/thread-503-1-60.html lingyizhongxiefa
	 * 
	 * 寻找数列中下降最大的差值，举个例子：[2, 3, 7, 4, 6, 1, 10] 输出 (7 - 1) = 6
	 * 
	 * 
	 * Meetings 
	 * http://www.meetqun.com/thread-2209-1-62.html
	 * http://www.meetqun.com/thread-4890-2-1.html
	 *  Sink zero in Binary Tree, 递归暴力 O(nlogn)退化O(n^2), 队列O(n).
	 *  
	 *  oncampus
	 *  http://www.meetqun.com/thread-337-1-64.html
	 *  
	 *  The number of valid combinations of a strings for given input array a[], 
where a=>1, z => 26, and 0 <= a <= 9
{1,1,1} => { aaa, ak, ka} => 3
{1,1,0} => {aj} => 1
follow up: O(1) memory
	 *
	 */
	
}
