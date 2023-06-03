package com.javakamp.hrms.business.abstracts;

import java.util.List;

import com.javakamp.hrms.business.requests.CreateSystemUserRequest;
import com.javakamp.hrms.business.responses.GetAllSystemUserResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;

public interface SystemUserService {
	
	DataResult<List<GetAllSystemUserResponse>> getAll();
	Result add(CreateSystemUserRequest createSystemUserRequest);

}
