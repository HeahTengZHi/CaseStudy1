package com.java.service;

import java.util.ArrayList;

import com.java.pojo.User;

public interface CaseStudyService {
	
	void userRegister(ArrayList<User> users);
	void userLogin(ArrayList<User> users);
	void userForgetPassword(ArrayList<User> users);
	void userBankApplication();
}
