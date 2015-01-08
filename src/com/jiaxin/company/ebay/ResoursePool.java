package com.jiaxin.company.ebay;
/*
 * http://blog.sina.com.cn/s/blog_75247c770100yxpb.html
 * 必须考虑线程安全的问题
 * http://www.infoq.com/cn/articles/double-checked-locking-with-delay-initialization
 * 这题目问了一下zalgorithm的群友，说singleton做 eager initialization， 放static 静态代码块，这样就补用管synchronized了，
 * 比lazy-load singleton好处在于，没有线程安全问题了。
 * 
 * 补充: 群友说严格来讲，construct 方法应该private，这样是无法new 实例的。同意!
 * 
 * 
 */
public class ResoursePool {
	private static ResoursePool instance = null;
	private ResoursePool() {}
	
	// Thread not safe
	public static ResoursePool getInstance() {
		if (instance == null) {
			instance = new ResoursePool();
		} 
		
		return instance;
	}
	
	// Thread safe - 并发度降低，因为每次都会执行锁定操作实现线程同步，这样很慢，双重锁就是解决这个问题
	public static synchronized ResoursePool getInstance2() {
		if (instance == null) {
			instance = new ResoursePool();
		} 
		
		return instance;
	}
	
	// Double-Checked lock 双重检查锁 - 兼顾Thread safe 和 并发度
	/*
	 * 这种写法使得只有在加载新的对象进行同步，在加载完了之后，其他线程在第九行就可以判断跳过锁的的代价直接到第15行代码了。做到很好的并发度
	 * 隐患： 假设线程A执行到了第9行，它判断对象为空，于是线程A执行到第12行去初始化这个对象，但初始化是需要耗费时间的，
	 * 但是这个对象的地址其实已经存在了。此时线程B也执行到了第九行，它判断不为空，于是直接跳到15行得到了这个对象，
	 * 但是，这个对象还没有被完整的初始化！得到一个没有初始化完全的对象有什么用！关于这个Double-Checked Lock的讨论有很多，目前公认这是一个Anti-Pattern，不推荐使用！
	 */
	
	public static ResoursePool getInstance3() {
		if (instance == null) {
			synchronized (ResoursePool.class) {
				if (instance == null) {
					instance = new ResoursePool();
				}
			}
		}
		
		return instance;
		
	}
	
	/* Initialization on Demand Holder.种方法使用内部类来做到延迟加载对象，在初始化这个内部类的时候，
	 * JLS(Java Language Sepcification)会保证这个类的线程安全。这种写法完全使用了Java虚拟机的机制进行同步保证，没有一个同步的关键字。
	 */
	private static class SingletonHolder {
		public final static ResoursePool instance = new ResoursePool();
	}
	
	public static ResoursePool getInstance4() {
		return SingletonHolder.instance;
	}
	
}
