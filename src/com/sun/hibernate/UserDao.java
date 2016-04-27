package com.sun.hibernate;

public interface UserDao {
	void saveUser(User user);
	User getUser(User user);
}
