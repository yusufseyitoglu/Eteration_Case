package com.eteration.simplebanking.response;

import java.util.List;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.Transaction;

import lombok.Data;

@Data
public class GetAccountResponse {
	private String accountNumber;
	private String owner;
	private double balance;
	private long Date;
	private List<Transaction> transactions;
	
	
	public GetAccountResponse(Account account) {
		this.accountNumber = account.getAccountNumber();
		this.owner = account.getOwner();
		this.balance = account.getBalance();
		this.Date = account.getCreateDate();
	}
	
	
}
