/*
 * Operation Class
 */
package model;

import java.util.Date;

public class Operation {
	
	private Date date;
	
	private OperationType type; //deposit or withdrawal
	
	private int amount;

	public Operation(Date date, OperationType type, int amount) {
		super();
		this.date = date;
		this.type = type;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Operation [" + date.toString() + "\t" + type + "\t" + amount + "]";
	}
	
	

}
