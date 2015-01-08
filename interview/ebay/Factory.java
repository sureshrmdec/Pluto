package interview.ebay;



public class Factory {
	/*
	 * 1. 简单工厂模式 Simple Factory
	 * 抽象一个类或者借口都可以，具体类 implements 或者extends, 然后新建一个factory, 传入name, 根据name来实例化 
	 public static Leifeng createLeifeng(String str) {
		Leifeng leifeng = null;
		if ("student".equals(str)) {
			leifeng = new Student();
		} else if ("volunteer".equals(str)) {
			leifeng = new Volunteer();
		}
	
		return leifeng;
	 }
	 * 
	 * 
	 * 2. 工厂方法模式 Factory Method
	 * 实体一样的，只是factory 抽象了，每个实体都有一个对应的factory 实现了总的factory，只生成这一个对象，
	 * 这样压力转到客户端了
	 * LeifengFactory leifengFactory = new StudentFactory();
		Leifeng leifeng = leifengFactory.createLeifeng();
		leifeng.swap();
		
	 * 	
	 * 3. 抽象工厂模式 Abstract Factory
	 */
	
	
	// BookStore 项目中的实例, daoFactory 是单利的，同事提供了createDao的工厂方法. So good!
	public class DaoFactory {
//		private static final DaoFactory daoFactory = new DaoFactory();
		
		private DaoFactory() {};
		
//		public static DaoFactory getInstance() {
//			return daoFactory;
//		}
		
		public <T> T createDao (String className, Class<T> clazz) {
			try {
				T t = (T) Class.forName(className).newInstance();
				return t;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void addPerson() {
//		private CategoryDao categoryDao = DaoFactory.getInstance()
//				.createDao("edu.pitt.bookstore.dao.impl.CategoryDaoImpl", CategoryDao.class);
	}
	
	
}
