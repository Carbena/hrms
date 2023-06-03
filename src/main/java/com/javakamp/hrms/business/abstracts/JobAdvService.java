package com.javakamp.hrms.business.abstracts;

import java.util.List;

import com.javakamp.hrms.business.requests.CreateJobAdvRequest;
import com.javakamp.hrms.business.responses.GetJobAdvResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;

public interface JobAdvService {

	Result add(CreateJobAdvRequest createJobAdvRequest);
	DataResult<List<GetJobAdvResponse>> getAll();
	DataResult<List<GetJobAdvResponse>> getAllSortedByDate();
	DataResult<List<GetJobAdvResponse>> getByEmployer(int employer);
	Result setInActiveJobAdv(int jobAdvId);

}
