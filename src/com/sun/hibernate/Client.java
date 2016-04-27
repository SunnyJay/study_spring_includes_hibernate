package com.sun.hibernate;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		testSpringAndHibernate();
	}

	private static void testSpringAndHibernate() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/sun/hibernate/beans.xml");
		UserDao studentDao = (UserDao) ctx.getBean("userDao");
		
		User user = new User();
		user.setName("jacksun");
		user.setPassword("123456");
		user.setCreateTime(new Date());
		user.setExpireTime(new Date());

		Group group = new Group();
		group.setName("pig2");
		user.setGroup(group);

		studentDao.saveUser(user);  //简化开发，操作封装到了studentDao中

		/*
		 * 这里需要注意的是，因为这里没有用到事务处理，Hibernate默认是不会自动提交事务的，所以刚开始测试的时候出现数据插入不了数据库的情况。
		 * 后来查了资料，知道要将事务设置为自动提交才能将数据插入到数据库中，这里只是为了测试，就改了过来。 如顶上所写<property
		 * name="hibernate.connection.autocommit">true</property>
		 * 在hibernate.cfg.xml中
		 * 
		 * 除了设置这个还需要在UserDaoImplement中设置hibernateTemplate.setCheckWriteOperations(false);
		 */
		
		/*Spring继承Hibernate还需要额外的spring-orm包。*/
	}

}
