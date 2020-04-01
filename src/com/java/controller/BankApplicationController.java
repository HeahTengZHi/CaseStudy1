package com.java.controller;

import java.util.ArrayList;
import java.util.Scanner;
import com.java.pojo.User;
import com.java.service.CaseStudyService;
import com.java.service.CaseStudyServiceImp;

public class BankApplicationController {
	
	private CaseStudyService refCaseStudyService=new CaseStudyServiceImp(); //reference of Interface and place Implements method
	
	
	Scanner sc =new Scanner(System.in);
	
	public void BankApplicationControllerLogic(ArrayList<User> users) {
		//Ask user to input
		//Assumption=> user already registered and logged in
		System.out.println("User Home Page");
		System.out.println("1.Register");
		System.out.println("2.Login");
		System.out.println("3.Forget Password");
		System.out.println("4.Logout (exit)");
		System.out.print("Enter your choice: ");
		String choise=sc.next();
		switch(choise) {
		case "1":
			refCaseStudyService.userRegister(users);//down casting
			BankApplicationControllerLogic(users);
			break;
		case "2":
			refCaseStudyService.userLogin(users);//down casting
			BankApplicationControllerLogic(users);
			break;
		case "3":
			refCaseStudyService.userForgetPassword(users);//down casting
			BankApplicationControllerLogic(users);
			break;
		case "4":
			System.out.println("\nLogout Successfully!!");
			break;
		default:
			System.out.println("\nInvalid Options\n");
			BankApplicationControllerLogic(users);
		}
	}
	
}
