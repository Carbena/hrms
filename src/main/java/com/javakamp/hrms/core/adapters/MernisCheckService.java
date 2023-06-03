package com.javakamp.hrms.core.adapters;

import java.rmi.RemoteException;

import com.javakamp.hrms.business.requests.CreateCandidateRequest;
import com.javakamp.hrms.core.utilities.results.Result;

public interface MernisCheckService {
	
	Result MernisCheck(CreateCandidateRequest createCandidateRequest) throws NumberFormatException, RemoteException;

}
