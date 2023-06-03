package com.javakamp.hrms.business.verifications.abstracts;

import com.javakamp.hrms.business.requests.VerifyEmailRequest;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.User;

public interface EmailVerificationService {
	
	Result verifyEmail(String mail);
	Result verifyAccount(VerifyEmailRequest verifyEmailRequest);
	void LogDb(User user);

}
