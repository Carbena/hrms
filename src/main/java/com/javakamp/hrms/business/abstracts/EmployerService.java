package com.javakamp.hrms.business.abstracts;

import java.util.List;

import com.javakamp.hrms.business.requests.CreateEmployerRequest;
import com.javakamp.hrms.business.responses.GetAllEmployerResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;

public interface EmployerService {
	
	DataResult<List<GetAllEmployerResponse>> getAll();
	Result add(CreateEmployerRequest createEmployerRequest);
	
}
