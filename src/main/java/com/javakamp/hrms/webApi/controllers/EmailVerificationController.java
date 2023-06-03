package com.javakamp.hrms.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javakamp.hrms.business.requests.VerifyEmailRequest;
import com.javakamp.hrms.business.verifications.concretes.EmailVerificationManager;
import com.javakamp.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/emailverification")
public class EmailVerificationController {
	
	private EmailVerificationManager emailVerificationManager;

	@Autowired
	public EmailVerificationController(EmailVerificationManager emailVerificationManager) {
		super();
		this.emailVerificationManager = emailVerificationManager;
	}
	
	@PostMapping("/verifymail")
	public Result verifyEmail(@RequestBody VerifyEmailRequest verifyEmailRequest) {
		return emailVerificationManager.verifyAccount(verifyEmailRequest);
	}
}
