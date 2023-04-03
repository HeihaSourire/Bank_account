/*
 * User Account Class
 */
package model;

import java.util.ArrayList;

public class UserAccount {
	private String user_name;
	
	private String password;
	
	private int balance = 0;
	
	private ArrayList<Operation> operations;
// this is the modification on the master branch
	public UserAccount(String user_name, String password) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.operations = new ArrayList<Operation>();
	}
	
	
	
	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public ArrayList<Operation> getOperations() {
		return operations;
	}



	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}



	//login in
	public boolean login(String name,String pwd){
	    if (this.user_name.equals(name) && this.password.equals(pwd)) {
	      return true;
	    } else {
	      return false;
	    }
	  }
	
	public void showOperations() {
		if (this.operations.size() == 0) {
			System.out.println("There is no operation");
		} else {
			for (Operation operation : this.operations) {
				System.out.println(operation.toString());
			}
		}
		
	}
}
