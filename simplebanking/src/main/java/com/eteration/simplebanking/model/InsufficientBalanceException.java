package com.eteration.simplebanking.model;

import java.io.Serializable;

import org.springframework.web.bind.annotation.ResponseStatus;


public class InsufficientBalanceException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;
	

	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}
