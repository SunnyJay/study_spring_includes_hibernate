package com.sun.hibernate;

import org.springframework.orm.hibernate4.HibernateTemplate;

public class UserDaoImplement implements UserDao{

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() { 
		return hibernateTemplate;
	}

	//HibernateTemplateҲ��Ҫע�� �ṩע���
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
		//����д��顣����ᱨ�쳣��Write operations are not allowed in read-only mode (FlushMode.MANUAL)...
		//�������ļ��еġ�<property name="hibernate.connection.autocommit">true</property>����ͬʹ��
		hibernateTemplate.setCheckWriteOperations(false); 
	}

	@Override
	public void saveUser(User user) {
		this.hibernateTemplate.save(user); //����hibernateTemplate��save
	}

	@Override
	public User getUser(User user) {
		return this.hibernateTemplate.get(User.class, user.getId()); 
	}

}
