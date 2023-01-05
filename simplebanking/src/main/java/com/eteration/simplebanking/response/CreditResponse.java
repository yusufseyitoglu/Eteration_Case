package com.eteration.simplebanking.response;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class CreditResponse {
	
	private HttpStatus status = HttpStatus.OK;
	private String approvalCode = "67f1aada-637d-4469-a650-3fb6352527ba";
}
