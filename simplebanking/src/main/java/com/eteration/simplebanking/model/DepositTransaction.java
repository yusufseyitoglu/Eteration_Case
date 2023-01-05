package com.eteration.simplebanking.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DepositTransaction extends Transaction {
	
	private double amount;
	private long date;
	private String type;
	private String approvalCode;
	
	public DepositTransaction(double amount) {
		
		this.amount = amount;
		this.date = System.currentTimeMillis();
		this.type = "DepositTransaction";
		this.approvalCode = "67f1aada-637d-4469-a650-3fb6352527ba";
	}
	
	

}
