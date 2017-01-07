package com.jiaxin.dataStructure;

import org.junit.Test;

public class DSTestClass {
	
	 @Test
    public void test() {
    	MyArrayList<Integer> list = new MyArrayList<Integer>();
    	System.out.println(list.isEmpty());
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	
    	System.out.print(list);
    	list.remove(2);
    	System.out.print(list);
    	list.remove(4);
    	System.out.print(list);
    	
    	list.add(3);
    	list.add(4);
    	list.add(3);
    	list.add(4);list.add(4);list.add(4);
    	System.out.print(list);
    	System.out.println(list.size());
    	System.out.println(list.isEmpty());
    	
    }
}
