package com.javakamp.hrms.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javakamp.hrms.business.requests.VerifySystemRequest;
import com.javakamp.hrms.business.verifications.abstracts.SystemVerificationService;
import com.javakamp.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/systemverify")
public class SystemVerificationController {
	
	private SystemVerificationService systemVerificationService;

	@Autowired
	public SystemVerificationController(SystemVerificationService systemVerificationService) {
		super();
		this.systemVerificationService = systemVerificationService;
	}
	
	@PostMapping("/verifyaccount")
	public Result verifyAccount(VerifySystemRequest verifySystemRequest) {
		return systemVerificationService.verifyAccount(verifySystemRequest);
	}

}
