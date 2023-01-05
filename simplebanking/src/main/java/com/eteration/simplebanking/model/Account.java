package com.eteration.simplebanking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNT_INFO")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long aId;
	private String Owner;
	private String AccountNumber;
	private double Balance;
	private long createDate;
	
	public Account(String owner, String accountNumber) {
		this.Owner = owner;
		this.AccountNumber = accountNumber;
		this.Balance = 0;
		this.createDate = System.currentTimeMillis();
	}
	

}
