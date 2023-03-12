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

	public UserAccount(String user_name, String password, int balance) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.balance = balance;
		this.operations = new ArrayList<Operation>();
	}
	
	//login in
	public boolean login(String name,String pwd){
	    if (this.user_name.equals(name) && this.password.equals(pwd)) {
	      return true;
	    } else {
	      return false;
	    }
	  }
	
	public String showOperations() {
		if (this.operations.size() == 0) {
			return "There is no operation";
		} else {
			for (Operation operation : this.operations) {
				return operation.toString();
			}
		}
		return null;
		
	}
}
