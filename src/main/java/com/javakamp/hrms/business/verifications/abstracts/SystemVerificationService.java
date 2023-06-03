package com.javakamp.hrms.business.verifications.abstracts;

import com.javakamp.hrms.business.requests.VerifySystemRequest;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.SystemVerification;

public interface SystemVerificationService {
	
	void logDb(SystemVerification systemVerification);
	Result verifyAccount(VerifySystemRequest verifySystemRequest);

}
