package com.java.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.dao.BankDAOImp;
import com.java.dao.BankDAOInterface;
import com.java.pojo.User;


public class CaseStudyServiceImp implements CaseStudyService{
	User loginUser=null;
	Scanner  sc=new Scanner(System.in);
	//reference of Interface and place Implements method
	BankDAOInterface refBankDAOInterface=new BankDAOImp();
	
	public String checkPassword(String registerPassword) {
		System.out.print("Retype Password: ");
		String retypePassword=sc.next();
		if(registerPassword.equals(retypePassword))
			return registerPassword;
		else
			System.out.println("\nPassword doesn't match!!");
			return checkPassword(registerPassword);
	}
	
	
	
	@Override
	public void userRegister(ArrayList<User> users) {
		//Call DAOImpl
		System.out.print("\nEnter Email address: ");
		String registerEmail=sc.next();
		for(User u:users) {
			if(u.getUserID().equals(registerEmail)) {
				System.out.println("\nEmail already exists!! ");
				userRegister(users);
				return;
			}
		}
		System.out.print("Enter Password: ");
		String registerPassword=sc.next();
		checkPassword(registerPassword);
		System.out.print("\n(Security Key), What is your favourite colour? : ");
		String setSecurityKey=sc.next();
		System.out.println(setSecurityKey+" is your security key, incase if you forget your password.\n");
		users.add(new User(registerEmail,registerPassword,0,setSecurityKey));
		System.out.println("Registration Successfully!! \n");
	}

	
	
	@Override
	public void userLogin(ArrayList<User> users) {
		//Check Email & PW
		System.out.print("Enter Email address: ");
		String email=sc.next();
		System.out.print("Enter Password: ");
		String password=sc.next();
		//if equals (Login Successful!!)
		//else (Invalid ID or Password)
		for(User u:users) {
			if(u.getUserID().equals(email) && u.getPassword().equals(password)) {
				loginUser=u;
				System.out.print("\nLogin Successfull!!\n");
				userBankApplication();
				return;
			}
		}
		System.out.println("Invalid ID or Password!!");
		userLogin(users);
	}

	
	
	@Override
	public void userForgetPassword(ArrayList<User> users) {
		// TODO Auto-generated method stub
		System.out.print("Enter Email address: ");
		String userEmail=sc.next();
		System.out.print("Enter Security Key, What is your favourite colour?: ");
		String securityKey=sc.next();
		//Check Email & PW
		for(User u:users) {
			if(u.getUserID().equals(userEmail) && u.getSecurityKey().equals(securityKey)) {
				System.out.println("Enter New Password: ");
				String newPassword=sc.next();
				checkPassword(newPassword);
				System.out.print("\n(Security Key), What is your favourite colour? : ");
				String newSecurityKey=sc.next();
				System.out.println(newSecurityKey+" is your security key, incase if you forget your password.\n");
				u.setPassword(newPassword);
				u.setSecurityKey(newSecurityKey);
				System.out.println("Your password has been reset successfully. \n");
				return;
			}else if(u.getUserID().equals(userEmail) && !u.getSecurityKey().equals(securityKey)) {
				System.out.println("Security Key doesn't match, Please try again. ");
				//go to retype label and retype new password and security key
				return;
			}
		}
		
		System.out.println("Invalid Account, Please try again!!");
	}
	
	void wishToContinue() {
		System.out.println("Wish to continue? (y/n)");
		String choice=sc.next();
		//If yes Back to savingAccount options
		if(choice.equalsIgnoreCase("y"))
			//The options provided by user
			userBankApplication();
		else {
			System.out.println("\nThanks for banking with Us\n");
			loginUser=null;
		}
	}
	
	@Override
	public void userBankApplication() {
		System.out.println("\nType 1: Check Available Bank Balance");
		System.out.println("Type 2: Deposit Amount");
		System.out.println("Type 3: Withdraw Amount");
		System.out.println("Enter your choice: ");
		String userChoice=sc.next();
		
		switch(userChoice) {
		case "1":
			refBankDAOInterface.checkBalance(loginUser);
			wishToContinue();
			break;
		case "2":
			refBankDAOInterface.deposit(loginUser);
			wishToContinue();
			break;
		case "3":
			refBankDAOInterface.withdraw(loginUser);
			wishToContinue();
			break;
		default:
			System.out.println("Invalid options!!");
			userBankApplication();
			break;}
	}


}
