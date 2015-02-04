package com.jiaxin.dataStructure;

public class Singleton {
	private static Helper helper = null;

	public Helper getHelper() {
		if (helper == null) {
			synchronized (this) {
				if (helper == null) {
					helper = new Helper();
				}
			}
		}
			
		return helper;
	}

	// other functions and members...

	class Helper {

	}
}
