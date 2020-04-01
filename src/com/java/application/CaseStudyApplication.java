package com.java.application;
import java.util.ArrayList;

import com.java.controller.BankApplicationController;
import com.java.pojo.User;

public class CaseStudyApplication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user1=new User("xyz@gmail.com","xyz123",1000.01,"red");
		User user2=new User("abc@gmail.com","abc123",900.51,"blue");
		ArrayList<User> users=new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		
		new BankApplicationController().BankApplicationControllerLogic(users);
	}
}
