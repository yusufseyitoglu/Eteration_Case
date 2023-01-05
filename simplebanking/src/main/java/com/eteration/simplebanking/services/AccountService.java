package com.eteration.simplebanking.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.PhoneBillPaymentTransaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.repositories.AccountRepository;
import com.eteration.simplebanking.request.CreditRequest;
import com.eteration.simplebanking.request.DebitRequest;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	Account account = new Account();
	
	@Transactional
	public void post(DepositTransaction depositTransaction) {
		this.account.setBalance(this.account.getBalance() + depositTransaction.getAmount());
		account = accountRepository.save(account);
	}
	
	
	
	@Transactional//(readOnly = false,  isolation = Isolation.READ_COMMITTED, propagation =Propagation.REQUIRED )
	public void post(WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException {
		this.account.setBalance(this.account.getBalance() - withdrawalTransaction.getAmount());
		
		WithdrawalTransaction.validateEnoughAmount(this.account.getBalance(), withdrawalTransaction.getAmount());
		
		this.account = accountRepository.save(account);
	}
	
	
	
	@Transactional(rollbackFor = Exception.class)
	public void post(PhoneBillPaymentTransaction billPaymentTransaction) throws InsufficientBalanceException {
		this.account.setBalance(this.account.getBalance() - billPaymentTransaction.getAmount());
		
		PhoneBillPaymentTransaction.validateEnoughAmount(this.account.getBalance(), billPaymentTransaction.getAmount());
		
		this.account = accountRepository.save(account);
	}
	
	
	
	@Transactional
	public Account credit(Long aId, CreditRequest creditrequest) {
		Optional<Account> account = accountRepository.findById(aId);
		
		if(account.isPresent() ) {
			Account creditlyAccount = account.get();
			creditlyAccount.setBalance(creditrequest.getAmount() + account.get().getBalance());
			return creditlyAccount;
			
		} else {
			return null;
		}
	}

	
	
	@Transactional(rollbackFor = Exception.class)
	public Account debit(Long aId, DebitRequest debitRequest) {

		Optional<Account> account = accountRepository.findById(aId);
		
		if(account.isPresent()) {
			Account debitlyAccount = account.get();
			debitlyAccount.setBalance(debitRequest.getAmount() - account.get().getBalance());
			return debitlyAccount;
		} else {
			return null;
		}	
	}
	
	
	
	@Transactional(readOnly = true)
	public Account getOneAccount(Long aId) {
		return accountRepository.findById(aId).orElse(null);
	}
	
}
