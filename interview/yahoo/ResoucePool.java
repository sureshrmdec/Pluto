package interview.yahoo;

public class ResoucePool {
	/*1. 书上的，都是static - 懒汉模式
	
	private static ResoucePool instance = null;
	private ResoucePool () {};
	public static ResoucePool getInstance() {
		if (instance == null) {
			instance = new ResoucePool();
		}
		
		return instance;
	}
	*/
	
	/* 跟地下静态代码块一样，属于饥汉 模式， greedy
	public static final ResourcePool instance = new ResourcePool();
	private ResourcePool() {};
	public static ResourcePool getInstance() {
		return instance;
	}
	*/
	
	/* 静态代码块模式
	public static ResourcePool instance = null;
	static {
		instance = new ResourcePool();
	}
	
	private ResourcePool() {};
	public static ResourcePool getInstance() {
		return instance;
	}
	*/
	
	
	/*
	synchronized getInstance 
	 */
	
	/* double lock
	public static ResourcePool getInstance() {
		if (instance == null) {
			synchronized (ResoucePool.class) {
				if (instance == null) {
					instance = new ResoucePool();
				}
			}
		}
	}
	*/
}
