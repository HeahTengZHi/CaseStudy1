package com.java.dao;

import com.java.pojo.User;

public interface BankDAOInterface {
	void checkBalance(User ref);
	void deposit(User ref);
	void withdraw(User ref);
}
