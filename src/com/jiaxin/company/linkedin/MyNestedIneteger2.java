package com.jiaxin.company.linkedin;

import java.util.List;


import com.jiaxin.company.linkedin.SumOfNestedInteger.NestedInteger;

public class MyNestedIneteger2 implements NestedInteger {
	private Integer theSingleInteger;
	private List<NestedInteger> theList;
	
	public MyNestedIneteger2() {
		
	}
	
	public MyNestedIneteger2(Integer theSingleInteger, List<NestedInteger> theList) {
		this.theSingleInteger = theSingleInteger;
		this.theList = theList;
	}
	
	@Override
	public boolean isInteger() {
		return null == theList && null != theSingleInteger;
	}

	@Override
	public Integer getInteger() {
		return theSingleInteger;
	}

	@Override
	public List<NestedInteger> getList() {
		// TODO Auto-generated method stub
		return theList;
	}
}
