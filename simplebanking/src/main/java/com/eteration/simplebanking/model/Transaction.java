package com.eteration.simplebanking.model;

import lombok.Data;

@Data
public abstract class Transaction {
	
	/* Actually i would try to get object here with used same fields (like approvalCode, date, type, amount) 
	 * and when we get a new transaction, we create object with Transaction abstract class and we can implement 
	 * easier. But now i am not good at to do that so i did not. it is just my opinion, may wrong
	*/
}
