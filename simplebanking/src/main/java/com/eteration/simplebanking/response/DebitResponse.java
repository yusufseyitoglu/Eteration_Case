package com.eteration.simplebanking.response;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class DebitResponse {
	
	private HttpStatus status = HttpStatus.OK;
	private String approvalCode = "a66cce54-335b-4e46-9b49-05017c4b38dd";

}
