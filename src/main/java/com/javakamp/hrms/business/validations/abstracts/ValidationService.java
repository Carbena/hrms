package com.javakamp.hrms.business.validations.abstracts;

import java.net.URISyntaxException;

import com.javakamp.hrms.business.requests.CreateCandidateRequest;
import com.javakamp.hrms.business.requests.CreateEmployerRequest;
import com.javakamp.hrms.core.utilities.results.Result;

public interface ValidationService {
	
	Result isMailUsed(String mail);
	Result isNationalityUsed(String nationality);
	Result isCreateCandidateEmpty(CreateCandidateRequest candidateRequest);
	Result isCreateEmployerEmpty(CreateEmployerRequest createEmployerRequest);
	Result isPasswordMatches( String password, String rePassword);
	Result isCompanyMatchesMail(CreateEmployerRequest createEmployerRequest) throws URISyntaxException;
	Result isJobTitleUsed(String title);
}
