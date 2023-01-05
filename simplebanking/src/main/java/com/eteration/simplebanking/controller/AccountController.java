package com.eteration.simplebanking.controller;
//This class is a place holder you can change the complete implementation

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.request.CreditRequest;
import com.eteration.simplebanking.request.DebitRequest;
import com.eteration.simplebanking.response.GetAccountResponse;
import com.eteration.simplebanking.services.AccountService;

@RestController
@RequestMapping("/account")
@EnableTransactionManagement
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

    @PostMapping("/{aId}/credit/{accountNumber}")
    public ResponseEntity<?> credit(@PathVariable Long aId, @PathVariable String accountNumber, @RequestBody CreditRequest creditRequest) {
    	Account account = accountService.credit(aId, creditRequest);
    	if(account != null) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PostMapping("/{aId}/debit/{accountNumber}")
    public ResponseEntity<?> debit(@PathVariable Long aId, @PathVariable String accountNumber, @RequestBody DebitRequest debitRequest) {
    	Account account = accountService.debit(aId, debitRequest);

    	if(account != null) {
    		return new ResponseEntity<>(HttpStatus.OK);
    	}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/{aId}/{accountNumber}")
    public GetAccountResponse getOneAccount(@PathVariable Long aId, @PathVariable String accountNumber) {
		Account account = accountService.getOneAccount(aId);
		
		if(account == null) {
			return null;
		} else {
			return new GetAccountResponse(account);
		}
	}
	
	
}
