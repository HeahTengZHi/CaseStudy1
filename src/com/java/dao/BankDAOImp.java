package com.java.dao;
import java.util.Scanner;
import com.java.pojo.User;

public class BankDAOImp implements BankDAOInterface {
	static int amount=0;
	Scanner  sc=new Scanner(System.in);
	
	@Override
	public void checkBalance(User refUser) {
		// TODO Auto-generated method stub
		System.out.println("Total Amount: "+refUser.getAmount());
	}

	@Override
	public void deposit(User refUser) {  
		// TODO Auto-generated method stub
		System.out.print("Enter Amount: ");
		double amount=sc.nextDouble();
		if(amount<0) {
			System.out.println("Amount can't be negative!! \n");
			deposit(refUser);
			return;
		}else {
			refUser.setAmount(amount+refUser.getAmount());
			System.out.println(amount+ " dollar deposited successfully\n");
		}
	}

	@Override
	public void withdraw(User refUser) {
		// TODO Auto-generated method stub
		System.out.print("Enter Amount: ");
		double amount=sc.nextDouble();
		if(amount>refUser.getAmount()) {
			System.out.println("Sorry!! insufficient balance");
			withdraw(refUser);
			return;
		}else if(amount<0) {
			System.out.println("Amount can't be negative!! ");
			withdraw(refUser);
			return;
		}else {
			//deduct and update account balance 
			refUser.setAmount(refUser.getAmount()-amount);
			//Show the account balance
			System.out.println("\nAccount Balance "+refUser.getAmount()+" dollar.");
			System.out.println("Transaction Successful!!\n");
		}
	}

	

	

}
