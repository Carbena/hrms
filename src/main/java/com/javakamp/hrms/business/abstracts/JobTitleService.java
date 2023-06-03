package com.javakamp.hrms.business.abstracts;

import java.util.List;

import com.javakamp.hrms.business.requests.CreateJobTitleRequest;
import com.javakamp.hrms.business.responses.GetAllJobTitleResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;

public interface JobTitleService {
	Result add(CreateJobTitleRequest createJobTitleRequest);
	DataResult<List<GetAllJobTitleResponse>> getAll();
	
}
