package service;

import java.util.Date;
import java.util.Scanner;

import model.Operation;
import model.OperationType;
import model.UserAccount;

public class UserAccountService implements UserAccountServiceInterface {
	Scanner inputScanner = new Scanner(System.in);
	
	private UserAccount user;

	@Override
	public void login() {
		initUser();
		boolean f;
	    int count=0;//times of login
	    
	    //login validate
	    do {
	      System.out.println("Please enter your username :");
	      String name=inputScanner.next();
	      System.out.println("Please enter your password :");
	      String pwd=inputScanner.next();
	      f=user.login(name, pwd);
	      count++;
	      if (!f) {
	        System.out.println("Login fail��you have "+(3-count)+" times");
	      }
	    } while (f==false&&count<3);
	    
	    //login succeed
	    if (f) {
	      int choose;
		//display menu
	      do {
	    	  System.out.println("1��deposit");
	    	  System.out.println("2��withdrawal");
	    	  System.out.println("3��check");
	    	  System.out.println("4��exit");
	    	  System.out.println("Please choose :");
	    	  choose=inputScanner.nextInt();
	        switch (choose) {
	        case 1://deposit
	          addMoney();
	          break;
	        case 2://withdrawal
	          getMoney();
	          break;
	        case 3://check
	          info();
	          break;
	        default://exit
	          System.exit(0);
	          System.out.println("Thank you for using");
	          break;
	        }
	      } while (choose==1||choose==2||choose==3);
	    }else {
	      System.out.println("More than three times, please contact you agence");
	    }

	}

	@Override
	public void info() {
		user.showOperations();
		System.out.println("balance : " + user.getBalance());
	}

	@Override
	public void addMoney() {
		// TODO Auto-generated method stub
		System.out.println("Please enter the amount of the deposit : ");
		int money = inputScanner.nextInt();
		if (money < 0) {
			System.out.println("wrong amount, Please enter again");
			addMoney();
		} else {
			user.setBalance(money + user.getBalance());
			Date date = new Date();
			user.getOperations().add(new Operation(date, OperationType.DEPOSIT, money));
			System.out.println("Deposit " + money + " succeed");
		}
	}

	@Override
	public void getMoney() {
		System.out.println("Please enter the amount of the withdrawal : ");
		int money = inputScanner.nextInt();
		if (money < 0) {
			System.out.println("wrong amount, Please enter again");
		} else {
			if (money > user.getBalance()) {
				System.out.println("Insufficient balance on your account!");
			} else {
				user.setBalance(user.getBalance() - money);
				Date date = new Date();
				user.getOperations().add(new Operation(date, OperationType.WITHDRAWAL, money));
				System.out.println("Withdrawal " + money + " succeed");
			}
		}

	}
	
	//initialize a user
	public void initUser() {
		user = new UserAccount("admin", "123456");
	}

}
