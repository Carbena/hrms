package com.javakamp.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import com.javakamp.hrms.business.requests.CreateCandidateRequest;
import com.javakamp.hrms.business.responses.GetAllCandidateResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;

public interface CandidateService {
	
	Result add(CreateCandidateRequest createCandidateRequest) throws NumberFormatException, RemoteException;
	DataResult<List<GetAllCandidateResponse>> getAll();

}
