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

		studentDao.saveUser(user);  //�򻯿�����������װ����studentDao��

		/*
		 * ������Ҫע����ǣ���Ϊ����û���õ�������HibernateĬ���ǲ����Զ��ύ����ģ����Ըտ�ʼ���Ե�ʱ��������ݲ��벻�����ݿ�������
		 * �����������ϣ�֪��Ҫ����������Ϊ�Զ��ύ���ܽ����ݲ��뵽���ݿ��У�����ֻ��Ϊ�˲��ԣ��͸��˹����� �綥����д<property
		 * name="hibernate.connection.autocommit">true</property>
		 * ��hibernate.cfg.xml��
		 * 
		 * ���������������Ҫ��UserDaoImplement������hibernateTemplate.setCheckWriteOperations(false);
		 */
		
		/*Spring�̳�Hibernate����Ҫ�����spring-orm����*/
	}

}
