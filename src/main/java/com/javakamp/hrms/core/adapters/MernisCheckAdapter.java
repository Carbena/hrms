package com.javakamp.hrms.core.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.requests.CreateCandidateRequest;
import com.javakamp.hrms.core.utilities.results.ErrorResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessResult;

@Service
public class MernisCheckAdapter implements MernisCheckService {

	@Override
	public Result MernisCheck(CreateCandidateRequest createCandidateRequest)
			throws NumberFormatException, RemoteException {

		boolean result = true;

		/*
		 * KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		 * 
		 * boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(
		 * Long.parseLong(createCandidateRequest.getNationalityId()),
		 * createCandidateRequest.getFirstName().toUpperCase(),
		 * createCandidateRequest.getLastName().toUpperCase(),
		 * Integer.parseInt(createCandidateRequest.getBithYear()));
		 * 
		 * return (result) ? new SuccessResult() : new ErrorResult();
		 */

		if (!result) {
			return new ErrorResult("Mernis bilgileri eslesmedi");

		}

		return new SuccessResult();

	}

}
