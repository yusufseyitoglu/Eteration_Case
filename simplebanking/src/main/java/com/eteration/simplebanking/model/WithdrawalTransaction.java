package com.eteration.simplebanking.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class WithdrawalTransaction extends Transaction{

	private double amount;
	private long date;
	private String type;
	private String approvalCode;

	public WithdrawalTransaction(double amount) {
		
		this.amount = amount;
		this.date = System.currentTimeMillis();
		this.type = "WithdrawalTransaction";
		this.approvalCode = "67f1aada-637d-4469-a650-3fb6352527ba";
	}


	public static boolean validateEnoughAmount(double accountBalance, double withdrawalamount) throws InsufficientBalanceException {
		if(withdrawalamount > accountBalance) {
			throw new InsufficientBalanceException("Insufficient balance exception!!");
		}
		return true;		
	}
}
