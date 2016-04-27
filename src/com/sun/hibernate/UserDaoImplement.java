package com.sun.hibernate;

import org.springframework.orm.hibernate4.HibernateTemplate;

public class UserDaoImplement implements UserDao{

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() { 
		return hibernateTemplate;
	}

	//HibernateTemplate也需要注入 提供注入口
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
		//禁用写检查。否则会报异常：Write operations are not allowed in read-only mode (FlushMode.MANUAL)...
		//与配置文件中的“<property name="hibernate.connection.autocommit">true</property>”共同使用
		hibernateTemplate.setCheckWriteOperations(false); 
	}

	@Override
	public void saveUser(User user) {
		this.hibernateTemplate.save(user); //调用hibernateTemplate的save
	}

	@Override
	public User getUser(User user) {
		return this.hibernateTemplate.get(User.class, user.getId()); 
	}

}
