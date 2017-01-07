package com.jiaxin.dataStructure;

public class ResourcePollSingleton {
	private static ResourcePollSingleton instance = null;
	
	private ResourcePollSingleton() {
	}
	
	public static ResourcePollSingleton getInstance() {
		if (instance == null) {
			instance = new ResourcePollSingleton(); // lazy-load 
		}
		
		return instance;
	}
	
	//1. synchronized -- low 
	public static synchronized ResourcePollSingleton getInstance1() {
		if (instance == null) {
			instance = new ResourcePollSingleton();
		}
		
		return instance;
	}
	
	// 2. Double check lock - Lazy initialization + threadsafe
	
	// threadA create memory address for instance(not init successfully,needs time), threadB get instance but can't use it.
	public static ResourcePollSingleton getInstance2() {
		if (instance == null) {
			synchronized (ResourcePollSingleton.class) {
				if (instance == null) {
					instance = new ResourcePollSingleton();
				}
			}
		}
		
		return instance;
	}
	
	// Demand holder -- not same as eager.without using synchronize
	// SingletonHolder is not loaded untils the getInstance called
	//the static instance of that class is instantiated as part of class loading
	// JVM handle inner class lazy. JLS (Java Language Specification) make sure its thread safe 
	private static class SingletonHolder {
		public final static ResourcePollSingleton instance = new ResourcePollSingleton();
	}
	
	public static ResourcePollSingleton getInstance3() {
		return SingletonHolder.instance;
	}
	
	// eager
	// instance = new class();
	// getInstance -> resurn instance -> instance created at class-load time. 
	
	// java volatile. thread share shared variale, when some val accessed by thread, it force to read its value.
	// when it changes, thread must write back .s
	
}
