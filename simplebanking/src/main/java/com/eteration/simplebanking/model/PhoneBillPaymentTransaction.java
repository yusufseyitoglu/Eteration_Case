package com.eteration.simplebanking.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PhoneBillPaymentTransaction extends Transaction {

	private String companyName;
	private String phoneNumber;
	private double amount;
	private long date;
	private String type;
	private String approvalCode;
	
	
	public PhoneBillPaymentTransaction(String companyName, String phoneNumber, double amount) {

		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.amount = amount;
		this.date = System.currentTimeMillis();
		this.type = "PhoneBillPaymentTransaction";
		this.approvalCode = "57f1bsab-274b-6261-b964-6gs7234164dd";
	}
	

	public static boolean validateEnoughAmount(double accountBalance, double paymentAmount) throws InsufficientBalanceException {
		if(paymentAmount > accountBalance) {
			throw new InsufficientBalanceException("Insufficient balance exception!!");
		}
		return true;		
	}
	
}
